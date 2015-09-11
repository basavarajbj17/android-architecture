package co.techmagic.architecturetemplate.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.otto.Subscribe;

import co.techmagic.architecturetemplate.R;
import co.techmagic.architecturetemplate.strategies.CreateUserStrategy;
import co.techmagic.common.eventbus.BusNotifier;
import co.techmagic.common.events.UserCreatedEvent;
import co.techmagic.common.events.UserCreationErrorEvent;

public class MainActivity extends AppCompatActivity implements CreateUserStrategy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusNotifier.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusNotifier.unregister(this);
    }

    @Override
    @Subscribe
    public void handleUserCreated(UserCreatedEvent event) {
        //TODO: behavior here
    }

    @Override
    @Subscribe
    public void handleUserCreationError(UserCreationErrorEvent event) {
        //TODO: behavior here
    }
}
