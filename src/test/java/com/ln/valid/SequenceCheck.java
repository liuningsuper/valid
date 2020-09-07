package com.ln.valid;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({AvailableFlightGroup.class, DestinationFlightGroup.class})
public interface SequenceCheck {
}
