/*
 * ReaderLocker.java
 *
 * Created on 3 november 2007, 14:57
 *
 * 
 */

package outfit;

import usb.ivi.USB_ivi_device;

/**
 * Interface to the ivibot usb Device to lock and unlock a ReaderLocker
 * Uses ivibot library
 *
 * @author jand
 */
public class ReaderLocker {
    private USB_ivi_device dev;
    /** Creates a new instance of ReaderLocker */
    public ReaderLocker() {
        try {
        dev = new USB_ivi_device();
        } catch (Exception e){
            System.err.println("USB_IVI DLL Exception catched - device disabled");
            dev = null;
            return;
        }
        dev.getPortA().setPortPinDirections((byte)0);
        dev.getPortB().setPortPinDirections((byte)0);
        dev.getPortEC().setPortPinDirections((byte)0);
    }
    /** turn om all portB leds
     *
     */
    public void leds_on(){
        if (dev == null) return; // no device
        //dev.getPortB().setPortPinDirections((byte)0);
        dev.getPortB().setPortPinValues((byte)0xFF);
    }

    /**
     * turn off all portB leds
     */
    public void leds_off(){
        if (dev == null) return; // no device
        dev.getPortB().setPortPinValues((byte)0);
    }
    
}
