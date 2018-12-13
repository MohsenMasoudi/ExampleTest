package com.example.mohsen.exampletest.intent;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mohsen.exampletest.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;


@RuntimePermissions
public class ImplicitActivity extends AppCompatActivity {
    private static final int REQ_CODE_GET_PICTURE = 0;
    private static final int REQ_CODE_GET_PICTURE_FOR_GET_DATA = 1;
    private static final int REQ_CODE_GET_CONTENT = 2;
    //    To Use PermissionsDispatcher FirstContract you should add the plugin and after that go to generator and
//    generate(add PermissionsDispatcher dependencies ) after that select Activity and use (Generate RunTime Permission)and
//    select the method's you like after that don't forget to use this and don't forget to add permission to Manifest
//     IntentActivityPermissionsDispatcher.callPhoneWithPermissionCheck(this)

    @BindView(R.id.edit_txt_enter_detail_intent_activity)
    EditText editTxtEnterDetailIntentActivity;
    @BindView(R.id.edit_txt_enter_dial_number_intent_activity)
    EditText editTxtEnterDialNumberIntentActivity;
    @BindView(R.id.btn_send_text)
    Button btnSend;
    @BindView(R.id.btn_open_google)
    Button btnOpenGoogle;
    @BindView(R.id.btn_dial)
    Button btnDial;
    @BindView(R.id.btn_call)
    Button btnCall;
    @BindView(R.id.img_view_intent_implicit_activity)
    ImageView imgViewIntentImplicitActivity;
    @BindView(R.id.btn_get_picture)
    Button btnGetPicture;
    @BindView(R.id.edit_txt_enter_name_implicit_activity)
    EditText editTxtEnterNameIntentActivity;
    @BindView(R.id.btn_send_image)
    Button btnSendImage;
    @BindView(R.id.edit_txt_enter_email_address_implicit_activity)
    EditText editTxtEnterEmailAddress;
    @BindView(R.id.btn_send_email)
    Button btnSendEmail;
    @BindView(R.id.btn_get_contact)
    Button btnGetContact;
    private Long number;

    public static Intent newIntent(Context context) {
        return new Intent(context, ImplicitActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_implicit_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_send_text, R.id.btn_open_google, R.id.btn_dial, R.id.btn_call
            , R.id.btn_get_picture, R.id.btn_send_image, R.id.btn_send_email, R.id.btn_get_contact})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_send_text:
                getActionSendText();
                break;
            case R.id.btn_open_google:
                getActionOpenUrl();
                break;
            case R.id.btn_dial:
                getActionDial();
                break;
            case R.id.btn_get_picture:
                getPictureFromGallery();
                break;
            case R.id.btn_call:
                ImplicitActivityPermissionsDispatcher.callPermissionWithPermissionCheck(ImplicitActivity.this);
                break;
            case R.id.btn_send_image:
                getPictureIntent();
                break;
            case R.id.btn_send_email:
                getActionSendEmail();
                break;
            case R.id.btn_get_contact:
                ImplicitActivityPermissionsDispatcher.readContactWithPermissionCheck(this);
                break;
        }
    }


    @NeedsPermission(Manifest.permission.CALL_PHONE)
    void callPermission() {
        getActionCall();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        ImplicitActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    private void getPictureFromGallery() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQ_CODE_GET_PICTURE);
    }

    @SuppressLint("Recycle")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK)
            return;
        if (requestCode == REQ_CODE_GET_PICTURE) {
            assert data != null;
            setImage(data);
        } else if (requestCode == REQ_CODE_GET_PICTURE_FOR_GET_DATA) {
            assert data != null;
            getActionSendImage(data);
        } else if (requestCode == REQ_CODE_GET_CONTENT) {
            getContactOnResult(data);
        }
    }

    private void setImage(Intent data) {
        Uri uri = data.getData();
        boolean noException = true;
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
            noException = false;
        }
        if (noException) {
            imgViewIntentImplicitActivity.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "couldent find picture", Toast.LENGTH_SHORT).show();
        }
    }

    private void getActionOpenUrl() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("http://google.com");
        intent.setData(uri);
        Intent chooser = Intent.createChooser(intent, "Select an app");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    private void getActionDial() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        try {
            number = Long.valueOf(editTxtEnterDialNumberIntentActivity.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(this, "the number is invalid", Toast.LENGTH_SHORT).show();
        }
        if (number != null) {
            Uri uri = Uri.parse("tel:" + number);
            intent.setData(uri);
            Intent chooser = Intent.createChooser(intent, "Select an app");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
        }

    }

    private void getActionCall() {
        try {
            number = Long.valueOf(editTxtEnterDialNumberIntentActivity.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(this, "the number is invalid", Toast.LENGTH_SHORT).show();
        }
        if (number != null) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse(String.format("tel:%s", editTxtEnterDialNumberIntentActivity.getText().toString())));
            Intent chooser = Intent.createChooser(callIntent, "Select an app");
            if (callIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
        }
    }

    private void getActionDialByContact() {
        Intent read1 = new Intent();
        read1.setAction(Intent.ACTION_CALL);
        read1.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivity(read1);
    }

    private void getActionSendText() {
        String s;
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        try {
            s = editTxtEnterNameIntentActivity.getText().toString();
        } catch (Exception e) {
            e.printStackTrace();
            s = "";
        }
        if (!s.equals("")) {
            intent.putExtra(Intent.EXTRA_TEXT, s);
            intent.setType("text/plain");
            Intent chooser = Intent.createChooser(intent, "Select an app");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
        } else {
            Toast.makeText(this, "Enter detail", Toast.LENGTH_SHORT).show();
        }
    }

    private void getActionSendEmail() {
        String subject = "";
        String detail = "";
        String emailAddres = "";
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        try {
            subject = editTxtEnterNameIntentActivity.getText().toString();
            detail = editTxtEnterDetailIntentActivity.getText().toString();
            emailAddres = editTxtEnterEmailAddress.getText().toString();
        } catch (Exception e) {
            e.printStackTrace();
            subject = "";
        }
        if (!subject.equals("")) {
            intent.setType("text/rfc822");
            intent.putExtra(Intent.EXTRA_TEXT, detail);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_EMAIL, emailAddres);
            Intent chooser = Intent.createChooser(intent, "Select an app");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
        } else {
            Toast.makeText(this, "Enter the Blanks", Toast.LENGTH_SHORT).show();
        }
    }

    private void getPictureIntent() {
        Intent getPictureIntent = new Intent();
        getPictureIntent.setAction(Intent.ACTION_GET_CONTENT);
        getPictureIntent.setType("image/*");
        Intent chooser = Intent.createChooser(getPictureIntent, "Select an app");
        if (getPictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(chooser, REQ_CODE_GET_PICTURE_FOR_GET_DATA);

        }
    }

    private void getActionSendImage(Intent data) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        Uri uri = data.getData();
        if (uri != null) {
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.setType("text/plain");
            Intent chooser = Intent.createChooser(intent, "Select an app");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
        } else {
            Toast.makeText(this, "Enter detail", Toast.LENGTH_SHORT).show();
        }
    }

    private void getContact() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Choose an App"), REQ_CODE_GET_CONTENT);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void getContactOnResult(Intent data) {
        Uri uri = data.getData();
        ContentResolver contentResolver = getContentResolver();
        @SuppressLint("Recycle") Cursor cursor = null;
        if (uri != null) {
            cursor = contentResolver.query(uri, null,
                    null, null, null);
        }
        assert cursor != null;
        cursor.moveToFirst();
        String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        editTxtEnterNameIntentActivity.setText(name);
        if (Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
            // Query phone here. Covered next
            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
            assert phones != null;
            phones.moveToFirst();
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            editTxtEnterDialNumberIntentActivity.setText(phoneNumber);
            phones.close();
        }
    }

    @NeedsPermission(Manifest.permission.READ_CONTACTS)
    void readContact() {
        getContact();

    }
}
