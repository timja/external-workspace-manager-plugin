package org.jenkinsci.plugins.ewm;

import hudson.ExtensionList;
import hudson.ExtensionPoint;
import hudson.model.AbstractDescribableImpl;
import jenkins.model.Jenkins;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

import javax.annotation.CheckForNull;

/**
 * @author Alexandru Somai
 */
@Restricted(NoExternalUse.class)
public abstract class DiskInfoProvider extends AbstractDescribableImpl<DiskInfoProvider> implements ExtensionPoint {

    @CheckForNull
    private final Double readSpeed;

    @CheckForNull
    private final Double writeSpeed;

    protected DiskInfoProvider(@CheckForNull Double readSpeed, @CheckForNull Double writeSpeed) {
        this.readSpeed = readSpeed != null && readSpeed >= 0 ? readSpeed : null;
        this.writeSpeed = writeSpeed != null && writeSpeed >= 0 ? writeSpeed : null;
    }

    /**
     * @return all registered {@link DiskInfoProvider}s.
     */
    public static ExtensionList<DiskInfoProvider> all() {
        return Jenkins.getActiveInstance().getExtensionList(DiskInfoProvider.class);
    }

    @CheckForNull
    public Double getReadSpeed() {
        return readSpeed;
    }

    @CheckForNull
    public Double getWriteSpeed() {
        return writeSpeed;
    }
}
