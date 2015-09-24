package ca.bcit.cst.comp3717.messagesender;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity
        extends AppCompatActivity
{
    public static final int UPPERCASE_REQUEST = 1;
    private EditText messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageView = (EditText)findViewById(R.id.message_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,
                                  menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(final View view)
    {
        final String message;
        final Intent intent;

        message     = messageView.getText().toString();
        intent      = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.MESSAGE_EXTRA, message);
        startActivityForResult(intent, UPPERCASE_REQUEST);
    }

    @Override
    protected void onActivityResult(final int    requestCode,
                                    final int    resultCode,
                                    final Intent data)
    {
        if(requestCode == UPPERCASE_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                final String message;

                message = data.getStringExtra("result");
                messageView.setText(message);
            }
        }
    }
}
