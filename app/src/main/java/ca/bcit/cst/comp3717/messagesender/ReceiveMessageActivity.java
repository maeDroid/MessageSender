package ca.bcit.cst.comp3717.messagesender;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ReceiveMessageActivity
        extends AppCompatActivity
{
    public static final String MESSAGE_EXTRA = "message";
    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final Intent   intent;
        final String   message;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        intent      = getIntent();
        message     = intent.getStringExtra(MESSAGE_EXTRA);
        messageView = (TextView)findViewById(R.id.message_text);
        messageView.setText(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_receive_message,
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

    public void uppercase(final View view)
    {
        final Intent returnIntent;
        final String message;

        returnIntent = new Intent();
        message      = messageView.getText().toString();
        returnIntent.putExtra("result", message.toUpperCase());
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
