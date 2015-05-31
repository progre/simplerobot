package net.prgrssv.simplerobot;

import li.cil.oc.api.Network;
import li.cil.oc.api.network.Connector;
import li.cil.oc.api.network.Visibility;
import li.cil.oc.api.prefab.ManagedEnvironment;

public class UpgradePerpetualGenerator extends ManagedEnvironment {
	public UpgradePerpetualGenerator() {
		Connector node = Network.newNode(this, Visibility.Network)
				.withConnector()
				.create();
		setNode(node);
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void update() {
		super.update();
		((Connector) node()).changeBuffer(Double.MAX_VALUE);
	}
}
