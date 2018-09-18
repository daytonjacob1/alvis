/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al2tex;

import java.util.Comparator;

/**
 *
 * @author martins
 */
public interface DetailedAlignment extends Alignment
{    
    public abstract int     getQueryStart();
    public abstract int     getQueryEnd();
    public abstract int     getQuerySize();
    public abstract String  getQueryName();
    public abstract int     getTargetStart();
    public abstract int     getTargetEnd();
    public abstract int     getTargetSize();
    public abstract boolean isReverseAlignment();
    
    
    public static Comparator<DetailedAlignment> compareByQueryStart = new Comparator<DetailedAlignment>(){
        public int compare(DetailedAlignment alignment1, DetailedAlignment alignment2) {
            int td = alignment1.getQueryName().compareTo(alignment2.getQueryName());
            if(td != 0)
            {
                return td;
            }
            return alignment1.getQueryStart() - alignment2.getQueryStart();
        }
    };
}