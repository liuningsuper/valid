package com.ln.valid;



import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class WCGroupSequenceProvider implements DefaultGroupSequenceProvider<SegmentVo> {
    @Override
    public List<Class<?>> getValidationGroups(SegmentVo car) {
        List<Class<?>> defaultGroupSequence = new ArrayList<Class<?>>();
        defaultGroupSequence.add(SegmentVo.class);

        if (car!=null) {
            if(car.getFlag())
            {
                defaultGroupSequence.add(DestinationFlightGroup.class);
            }
        }

        return defaultGroupSequence;
    }

}
