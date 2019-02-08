package com.example.android.recipemanagernative.Database;

import android.provider.BaseColumns;

// Specifies the layout of the database schema.
public final class RecipeManagerContract {

    // Prevents the class from accidentally being instantiated.
    private RecipeManagerContract(){}

    // Inner class that defines the Category table contents.
    public static final class CategoryEntry implements BaseColumns{

        // Name of the database table.
        public final static String TABLE_NAME = "category";

        // Unique ID number for the category.
        // TYPE: INTEGER
        public final static String ID = BaseColumns._ID;

        // Name of the category.
        // TYPE: TEXT
        public final static String COLUMN_CATEGORY_NAME = "name";
    }

    // Inner class that defines the Recipe table contents.
    public static final class RecipeEntry implements BaseColumns{

        // Name of the database table.
        public final static String TABLE_NAME = "recipe";

        // Unique ID number for the recipe.
        // TYPE: INTEGER
        public final static String ID = BaseColumns._ID;

        // Name of the recipe.
        // TYPE: TEXT
        public final static String COLUMN_RECIPE_NAME = "name";

        // Image URI for the recipe image.
        // TYPE: STRING
        public final static String COLUMN_IMAGE_URI = "image_URI";

        // List of recipe ingredients.
        // TYPE: STRING
        public final static String COLUMN_INGREDIENTS_LIST = "ingredients_list";

        // Number of instructions in the recipe.
        // TYPE: INTEGER
        public final static String COLUMN_INSTRUCTION_COUNT = "instruction_count";

        // Total duration of the recipe.
        // TYPE: INTEGER
        public final static String COLUMN_TOTAL_DURATION = "total_duration";

        // Foreign key for a category.
        // TYPE: INTEGER
        public final static String FK_CATEGORY_ID = "fk_category_id";
    }

    // Inner class that defines the Instruction table contents.
    public static final class InstructionEntry implements BaseColumns{

        // Name of the database table.
        public final static String TABLE_NAME = "instruction";

        // Unique ID number for the instruction.
        // TYPE: INTEGER
        public final static String ID = BaseColumns._ID;

        // Sequence number for the instruction.
        // TYPE: INTEGER
        public final static String COLUMN_SEQUENCE_NUMBER = "sequence_number";

        // Description for the instruction.
        // TYPE: STRING
        public final static String COLUMN_DESCRIPTION = "description";

        // Duration for the instruction.
        // TYPE: INT
        public final static String COLUMN_DURATION = "duration";

        // Foreign key for a recipe.
        // TYPE: INTEGER
        public final static String FK_RECIPE_ID = "fk_recipe_id";
    }

    public static final class SQLCreateStatements{

        public static final String SQL_CREATE_CATEGORY =
                "CREATE TABLE " + CategoryEntry.TABLE_NAME + " (" +
                CategoryEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CategoryEntry.COLUMN_CATEGORY_NAME + " TEXT NOT NULL);";

        public static final String SQL_CREATE_RECIPE =
                "CREATE TABLE " + RecipeEntry.TABLE_NAME + " (" +
                RecipeEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RecipeEntry.COLUMN_RECIPE_NAME + " TEXT NOT NULL," +
                RecipeEntry.COLUMN_IMAGE_URI + " TEXT NOT NULL," +
                RecipeEntry.COLUMN_INGREDIENTS_LIST + " TEXT NOT NULL," +
                RecipeEntry.COLUMN_INSTRUCTION_COUNT + " INTEGER NOT NULL" +
                RecipeEntry.COLUMN_TOTAL_DURATION + " INTEGER NOT NULL," +
                "CONSTRAINT" + RecipeEntry.FK_CATEGORY_ID +
                "FOREIGN KEY (" + CategoryEntry.ID + ") " +
                "REFERENCES " + CategoryEntry.TABLE_NAME + "(" + CategoryEntry.ID + "));";

        public static final String SQL_CREATE_INSTRUCTION =
                "CREATE TABLE " + InstructionEntry.TABLE_NAME + " (" +
                InstructionEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                InstructionEntry.COLUMN_SEQUENCE_NUMBER + " INTEGER NOT NULL," +
                InstructionEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL," +
                InstructionEntry.COLUMN_DURATION + " INTEGER NOT NULL," +
                "CONSTRAINT" + InstructionEntry.FK_RECIPE_ID +
                "FOREIGN KEY (" + RecipeEntry.ID + ") " +
                "REFERENCES " + RecipeEntry.TABLE_NAME + "(" + RecipeEntry.ID + "));";
    }
}
