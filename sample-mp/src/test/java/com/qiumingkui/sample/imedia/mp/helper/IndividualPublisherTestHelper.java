package com.qiumingkui.sample.imedia.mp.helper;

import com.qiumingkui.sample.imedia.mp.domain.model.publisher.IndividualPublisher;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.IndividualPublisherBuilder;

public class IndividualPublisherTestHelper {

	public IndividualPublisher buildIndividualPublisherExample(){
		IndividualPublisher individualPublisher = IndividualPublisherBuilder.build(null, null, null);
		return individualPublisher;
	}
}
