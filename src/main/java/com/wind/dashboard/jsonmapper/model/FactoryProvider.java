package com.wind.dashboard.jsonmapper.model;

public class FactoryProvider {

    private static final String AGGREGATED = "AGGREGATED";
    private static final String DETAIL = "DETAIL";

    /**
     *
     * @param choice
     * @return
     */
    public static WidgetAbstractFactory getFactory(String choice) {
        if (AGGREGATED.equalsIgnoreCase(choice)) {
            return new AggregatedWidgetFactory();
        } else if (DETAIL.equalsIgnoreCase(choice)) {
            return new DetailWidgetFactory();
        }

        return null;
    }
}
