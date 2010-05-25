package max.gmail.notify.options;

import org.netbeans.spi.options.AdvancedOption;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;

public final class GmailAdvancedOption extends AdvancedOption {

    public String getDisplayName() {
        return NbBundle.getMessage(GmailAdvancedOption.class, "AdvancedOption_DisplayName_Plugin");
    }

    public String getTooltip() {
        return NbBundle.getMessage(GmailAdvancedOption.class, "AdvancedOption_Tooltip_Plugin");
    }

    public OptionsPanelController create() {
        return new GmailOptionsPanelController();
    }
}
