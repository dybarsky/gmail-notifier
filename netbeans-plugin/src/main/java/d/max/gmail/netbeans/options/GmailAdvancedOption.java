package d.max.gmail.netbeans.options;

import org.netbeans.spi.options.AdvancedOption;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;

public final class GmailAdvancedOption extends AdvancedOption {

    @Override
    public String getDisplayName() {
        return NbBundle.getMessage(GmailAdvancedOption.class, "AdvancedOption_DisplayName_Plugin");
    }

    @Override
    public String getTooltip() {
        return NbBundle.getMessage(GmailAdvancedOption.class, "AdvancedOption_Tooltip_Plugin");
    }

    @Override
    public OptionsPanelController create() {
        return new GmailOptionsPanelController();
    }
}
