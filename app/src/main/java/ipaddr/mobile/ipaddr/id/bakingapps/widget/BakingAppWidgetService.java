package ipaddr.mobile.ipaddr.id.bakingapps.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by iip on 8/10/17.
 */

public class BakingAppWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        BakingAppDataProvider data = new BakingAppDataProvider(this, intent);
        return data;
    }
}
