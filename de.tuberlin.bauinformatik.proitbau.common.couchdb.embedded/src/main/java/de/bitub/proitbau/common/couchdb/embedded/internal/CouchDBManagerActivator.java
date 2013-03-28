package de.bitub.proitbau.common.couchdb.embedded.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class CouchDBManagerActivator extends Plugin {
	
	private static CouchDBManagerActivator plugin;
	
	public static CouchDBManagerActivator getDefault() {
		return CouchDBManagerActivator.plugin;
	}
	
	/**
	 * Returns the ID of this plug-in from the manifest file.
	 * 
	 * @return ID of this plug-in from the manifest file
	 */
	public String getId() {
		return this.getBundle().getSymbolicName();
		
	}
	
	public void log(final int severity, final String message) {
		final IStatus status = new Status(severity, this.getId(), message);
		this.getLog().log(status);
	}
	
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		CouchDBManagerActivator.plugin = this;
	}
	
	@Override
	public void stop(final BundleContext context) throws Exception {
		super.stop(context);
		CouchDBManagerActivator.plugin = null;
	}
	
}
