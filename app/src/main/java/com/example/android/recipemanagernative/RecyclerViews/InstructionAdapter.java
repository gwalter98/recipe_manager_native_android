package com.example.android.recipemanagernative.RecyclerViews;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.recipemanagernative.Database.RecipeManagerContract;
import com.example.android.recipemanagernative.R;

import java.util.ArrayList;

public class InstructionAdapter extends RecyclerView.Adapter<InstructionAdapter.InstructionViewHolder> {

    private Cursor cursor; // Holds a cursor object.

    // Provides a reference to the views for each data item.
    public static class InstructionViewHolder extends RecyclerView.ViewHolder {

        private TextView instructionDescriptionTextView; // Holds the text view for the instruction description.

        private InstructionViewHolder(View view) {
            super(view);

            // Assigns the text view.
            instructionDescriptionTextView = view.findViewById(R.id.text_view_instruction_description);
        }
    }

    // Constructor for the InstructionAdapter class.
    public InstructionAdapter(Cursor cursor) {
        this.cursor = cursor;
    }

    // Creates new views.
    @Override
    @NonNull
    public InstructionAdapter.InstructionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflates the ingredients row view.
        View instructionRowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_instruction, parent, false);
        return new InstructionViewHolder(instructionRowView);
    }

    // Replaces the contents of a view.
    @Override
    public void onBindViewHolder(@NonNull InstructionViewHolder holder, int position) {

        // Checks the cursor can move to the position.
        if(!cursor.moveToPosition(position)){
            return;
        }

        // Gets the instruction sequence number and description from the rows in the cursor.
        String sequenceNumber = String.valueOf(cursor.getInt(cursor.getColumnIndex(RecipeManagerContract.InstructionEntry.COLUMN_SEQUENCE_NUMBER)));
        String instructionDescription = cursor.getString(cursor.getColumnIndex(RecipeManagerContract.InstructionEntry.COLUMN_DESCRIPTION));
        String instructionText = sequenceNumber + ". " + instructionDescription;

        // Sets the text of the view to the instruction description.
        holder.instructionDescriptionTextView.setText(instructionText);
    }

    // Returns the size of the dataset.
    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

}