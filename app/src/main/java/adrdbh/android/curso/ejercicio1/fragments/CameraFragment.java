package adrdbh.android.curso.ejercicio1.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Camera;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import adrdbh.android.curso.ejercicio1.R;

/**
 * Created by adrdbh on 2/3/16.
 */

public class CameraFragment extends Fragment {

    private final static int SELECT_PICTURE=200;
    private ImageView mSetPicture;
    public static CameraFragment newInstance() {

        CameraFragment cameraFragment = new CameraFragment();
        return cameraFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camera_fragment_layout, container, false);

        Button mChoosePictureButton = (Button) view.findViewById(R.id.btn1);

        mChoosePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Tomar Foto", "Elelegir de Galeria", "Cancelar"};

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("Elige una Opcion");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (options[which]=="Tomar Foto"){
                            openCamera();
                        }else if (options[which]=="Elegir de Galeria"){
                            selectFromGallery();
                        }else
                            dialog.dismiss();

                    }
                });
            }
        });

        return view;
    }

    private void openCamera() {
    }

    private void selectFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent.createChooser(intent,"Selecciona Una Opción"), SELECT_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SELECT_PICTURE:
                if (resultCode== Activity.RESULT_OK){
                    Uri path = data.getData();
                    mSetPicture.setImageURI(path);
                }
        }
    }
}
