// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2018
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.bitwig.framework.daw;

import de.mossgrabers.bitwig.framework.daw.data.SlotImpl;
import de.mossgrabers.framework.controller.IValueChanger;
import de.mossgrabers.framework.daw.IHost;
import de.mossgrabers.framework.daw.ISlotBank;
import de.mossgrabers.framework.daw.data.ISlot;

import com.bitwig.extension.controller.api.ClipLauncherSlotBank;


/**
 * Encapsulates the data of a slot bank.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class SlotBankImpl extends AbstractBankImpl<ClipLauncherSlotBank, ISlot> implements ISlotBank
{
    /**
     * Constructor.
     *
     * @param host The DAW host
     * @param valueChanger The value changer
     * @param slotBank The slot bank
     * @param numSlots The number of slots in the page of the bank
     */
    public SlotBankImpl (final IHost host, final IValueChanger valueChanger, final ClipLauncherSlotBank slotBank, final int numSlots)
    {
        super (host, valueChanger, slotBank, numSlots);
        this.initItems ();
    }


    /** {@inheritDoc} */
    @Override
    public ISlot getEmptySlot (final int startFrom)
    {
        final int start = startFrom >= 0 ? startFrom : 0;
        final int size = this.items.size ();
        for (int i = 0; i < size; i++)
        {
            final ISlot item = this.items.get ((start + i) % size);
            if (!item.hasContent ())
                return item;
        }
        return null;
    }


    /** {@inheritDoc} */
    @Override
    protected void initItems ()
    {
        for (int i = 0; i < this.pageSize; i++)
            this.items.add (new SlotImpl (this.bank, this.bank.getItemAt (i), i));
    }
}