// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2018
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.framework.daw;

import de.mossgrabers.framework.daw.data.ILayer;


/**
 * Interface to a layer bank.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public interface ILayerBank extends IChannelBank<ILayer>
{
    /**
     * Check if there is at least 1 existing layer.
     *
     * @return True if there are no layers
     */
    boolean hasZeroLayers ();
}