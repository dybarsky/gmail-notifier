/**
 * author: Maxim Dybarskiy
 * date:   21.05.2010
 * time:   17:51:49
 */
package d.max.gmail.netbeans;

import org.openide.modules.ModuleInstall;
import org.openide.windows.WindowManager;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        WindowManager.getDefault().invokeWhenUIReady(new Runnable() {
            @Override
            public void run() {
                Notifier.start();
            }
        });
    }
}
