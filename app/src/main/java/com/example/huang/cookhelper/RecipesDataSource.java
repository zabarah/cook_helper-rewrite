package com.example.huang.cookhelper;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RecipesDataSource {

        // Database fields
        private SQLiteDatabase database;
        private MySQLiteHelper dbHelper;
        private String[] allColumns = { MySQLiteHelper.COLUMN_NAME,
                        MySQLiteHelper.COLUMN_NAME };

        public RecipesDataSource(Context context) {
                dbHelper = new MySQLiteHelper(context);
        }

        public void open() throws SQLException {
                database = dbHelper.getWritableDatabase();
        }

        public void close() {
                dbHelper.close();
        }

        public Recipe createRecipe(Recipe recipe) {
                ContentValues values = new ContentValues();

                //a bunch of puts for all the columns
                values.put(MySQLiteHelper.COLUMN_NAME, recipe.getName());
                values.put(MySQLiteHelper.COLUMN_CLASSR, recipe.getClassr());
                values.put(MySQLiteHelper.COLUMN_TYPE, recipe.getType());
                values.put(MySQLiteHelper.COLUMN_CATEGORY, recipe.getCategory());
                values.put(MySQLiteHelper.COLUMN_ING, android.text.TextUtils.join(",", recipe.getIng()));
                values.put(MySQLiteHelper.COLUMN_CAL, recipe.getCal());
                values.put(MySQLiteHelper.COLUMN_COOK, recipe.getCook());
                values.put(MySQLiteHelper.COLUMN_PREP, recipe.getPrep());
                values.put(MySQLiteHelper.COLUMN_STEPS, recipe.getSteps());

                long insertId = database.insert(MySQLiteHelper.TABLE_RECIPES, null,
                                values);
                Cursor cursor = database.query(MySQLiteHelper.TABLE_RECIPES,
                                allColumns, MySQLiteHelper.COLUMN_NAME + " = " + insertId, null,
                                null, null, null);
                cursor.moveToFirst();
                Recipe newRecipe = cursorToRecipe(cursor);
                cursor.close();
                return newRecipe;
        }

        public void deleteRecipe(Recipe recipe) {
                String name = recipe.getName();
                System.out.println("Recipe deleted with id: " + name);
                database.delete(MySQLiteHelper.TABLE_RECIPES, MySQLiteHelper.COLUMN_NAME
                                + " = " + name, null);
        }

        public List<Recipe> getAllRecipes() {
                List<Recipe> recipes = new ArrayList<>();

                Cursor cursor = database.query(MySQLiteHelper.TABLE_RECIPES,
                                allColumns, null, null, null, null, null);

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                        Recipe recipe = cursorToRecipe(cursor);
                        recipes.add(recipe);
                        cursor.moveToNext();
                }
                // make sure to close the cursor
                cursor.close();
                return recipes;
        }

        private Recipe cursorToRecipe(Cursor cursor) {
                Recipe recipe = new Recipe();
                /* NEED TO WRITE RETURN METHOD
                Recipe.setName(cursor.getLong(0));
                Recipe.setRecipe(cursor.getString(1));
                */
                return recipe;
        }

        public Recipe getRecipeAtPosition(int position){
                List<Recipe> Recipes = new ArrayList<Recipe>();

                Cursor cursor = database.query(MySQLiteHelper.TABLE_RECIPES,
                        allColumns, null, null, null, null, null);

                cursor.moveToFirst();

                Recipe recipe = cursorToRecipe(cursor);
                // make sure to close the cursor
                cursor.close();
                return recipe;
        }
}
