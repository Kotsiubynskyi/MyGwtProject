package ua.company.gwt.shared.dto;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

/**
 * @author EvgeniyKot on 24.11.2014.
 */
public interface CallInfoProperties extends PropertyAccess<CallInfo> {

    ModelKeyProvider<CallInfo> startDate();

    ValueProvider<CallInfo, CallType> callType();
    @Editor.Path("startDate")
    ValueProvider<CallInfo, Long> startDateCol();

    @Editor.Path("destNumber")
    LabelProvider<CallInfo> destNumberLabel();

    ValueProvider<CallInfo, String> destNumber();

    ValueProvider<CallInfo, Double> cost();

    ValueProvider<CallInfo, Long> endDate();

    ValueProvider<CallInfo, Long> callDuration();

}
