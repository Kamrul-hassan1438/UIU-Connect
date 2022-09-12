package Massage.massage;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Data implements Serializable,Cloneable{

    public String message;

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}