package com.gettipsi.stripe;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;

/**
 * Created by remer on 11/8/17.
 */

public class RedirectUriReceiver extends Activity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (StripeModule.getInstance() == null) {
      sendResult(RESULT_CANCELED);
    }

    try {
      StripeModule.getInstance().processRedirect(getIntent().getData());
      sendResult(RESULT_OK);
    } catch (NullPointerException error) {
      sendResult(RESULT_CANCELED);
    }
  }

  private void sendResult(int resultCode) {
    setResult(resultCode);
    finish();
  }
}
