package testing.ck;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new MyOnClickListener() {
            @Override
            protected void onViewClick(View view) {
                showToast();
            }
        });
        findViewById(R.id.button1).setOnClickListener(new MyOnClickListener() {
            @Override
            protected void onViewClick(View view) {
                showToast1();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new MyOnClickListener() {
            @Override
            protected void onViewClick(View view) {
                showToast2();
            }
        });
    }

    private void showToast() {
        MDialog.getInstance()
                .create(this)
                .setTitle("Dialog")
                .setMessage("This is dummy Message This is dummy Message This is dummy Message This is dummy Message This is dummy Message ")
                .setPositiveButton("Okay", new MDialog.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(AlertDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new MDialog.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(AlertDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .show(true);
    }

    private void showToast1() {
        MDialog.showToast(this, "My Custom Title", "My custom message My custom message My custom message My custom message ");
    }

    private void showToast2() {
        MDialog.showToast(this, "My custom message My custom message My custom message My custom message ");
    }
}
