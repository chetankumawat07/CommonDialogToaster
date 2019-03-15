package testing.ck;

import android.os.SystemClock;
import android.view.View;

public abstract class MyOnClickListener implements View.OnClickListener {

    protected abstract void onViewClick(View view);

    private long mLastClickTime = 0;

    @Override
    public void onClick(View v) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 300) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();

        onViewClick(v);
    }

}
