package testing.ck;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MDialog {

    private static Object mInstance;
    private static AlertDialog.Builder builder;
    private static AlertDialog alertDialog;
    private View alertDialogView;

    public synchronized static MDialog getInstance() {
        if (mInstance == null) {
            mInstance = new MDialog();
        }
        return (MDialog) mInstance;
    }

    public MDialog create(Context context) {
        new MDialog();
        builder = new AlertDialog.Builder(context, R.style.CommonDialogTheme);
        alertDialogView = ((Activity) context).getLayoutInflater()
                .inflate(R.layout.common_dialog, null);
        builder.setView(alertDialogView);
        return getInstance();
    }

    public MDialog setTitle(String title) {
        TextView textView = alertDialogView.findViewById(R.id.title);
        textView.setText(title);
        textView.setVisibility(View.VISIBLE);
        return getInstance();
    }

    public MDialog setMessage(String message) {
        TextView textView = alertDialogView.findViewById(R.id.message);
        textView.setText(message);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setVisibility(View.VISIBLE);
        return getInstance();
    }

    public MDialog setPositiveButton(CharSequence title,
                                     final DialogInterface.OnClickListener onClickListener) {
        Button button = alertDialogView.findViewById(R.id.positiveButton);
        button.setText(title);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new MyOnClickListener() {
            @Override
            protected void onViewClick(View view) {
                if (onClickListener != null && alertDialog != null) {
                    onClickListener.onClick(alertDialog);
                }
            }
        });
        return getInstance();
    }

    public MDialog setNegativeButton(CharSequence title,
                                     final DialogInterface.OnClickListener onClickListener) {
        Button button = alertDialogView.findViewById(R.id.NegativeButton);
        button.setText(title);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new MyOnClickListener() {
            @Override
            protected void onViewClick(View view) {
                if (onClickListener != null && alertDialog != null) {
                    onClickListener.onClick(alertDialog);
                }
            }
        });
        return getInstance();
    }

    public MDialog setNeutralButton(CharSequence title,
                                    final DialogInterface.OnClickListener onClickListener) {
        Button button = alertDialogView.findViewById(R.id.NeutralButton);
        button.setText(title);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new MyOnClickListener() {
            @Override
            protected void onViewClick(View view) {
                if (onClickListener != null && alertDialog != null) {
                    onClickListener.onClick(alertDialog);
                }
            }
        });
        return getInstance();
    }

    public void show(boolean cancelable) {

        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }

        alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(cancelable);
        alertDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        alertDialog.getWindow().setDimAmount(0.5f);
        alertDialog.show();
    }

    public static void showToast(Context context, String title, String message) {
        getInstance().create(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(AlertDialog dialog) {
                        dialog.dismiss();
                    }
                }).show(true);
    }

    public static void showToast(Context context, String message) {
        getInstance().create(context)
                .setMessage(message)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(AlertDialog dialog) {
                        dialog.dismiss();
                    }
                }).show(true);
    }

    public static class DialogInterface {
        interface OnClickListener {
            void onClick(AlertDialog dialog);
        }
    }
}
