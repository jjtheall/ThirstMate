/*
 * ThirstMate App
 * @author: Jack Theall, MacArthur Mills
 * Developed Spring '22
 */

package edu.quinnipiac.ser210.thirstmate;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.LinkedList;
import java.util.List;

public class AddIngredientDialog extends DialogFragment {

    List<Ingredient> ingredients;
    ShoppingListAdapter adapter;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_addingredient, null);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.add_ingredient_confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText text1 = (EditText) getDialog().findViewById(R.id.addIngredientName);
                        EditText text2 = (EditText) getDialog().findViewById(R.id.addIngredientQuantity);
                        String text1String = text1.getText().toString();
                        String text2String = text2.getText().toString();

                        if(!text1String.equals("")){
                            if(!text2String.equals("")) {
                                try{
                                    boolean newIngredient = true;
                                    for(int i = 0; i < ShoppingListFragment.ingredientsShopping.size(); i++){
                                        if(ShoppingListFragment.ingredientsShopping.get(i).getName().equals(text1String)){
                                            newIngredient = false;
                                            Toast toast = Toast.makeText(getActivity(), "Ingredient already in list", Toast.LENGTH_SHORT);
                                            toast.show();
                                        }
                                    }
                                    if(newIngredient) {
                                        ShoppingListFragment.ingredientsShopping.add(new Ingredient(text1String, Double.parseDouble(text2String)));
                                        ShoppingListFragment.updateIngredients(ingredients, adapter);
                                    }
                                    text2.setText("");
                                } catch (NumberFormatException e){
                                    Toast toast = Toast.makeText(getActivity(), "Ingredient quantity must be a number", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                            else{
                                Log.d("No way", "How");
                                ShoppingListFragment.ingredientsShopping.add(new Ingredient(text1.getText().toString()));
                                ShoppingListFragment.updateIngredients(ingredients, adapter);
                            }
                        } else {
                            Toast toast = Toast.makeText(getActivity(), "Must enter an ingredient name", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    }
                })
                .setNegativeButton(R.string.add_ingredient_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddIngredientDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public void setIngredients(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public void setAdapter(ShoppingListAdapter adapter){
        this.adapter = adapter;
    }
}