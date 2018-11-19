/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al2tex.AlignmentFiles;

import java.util.Comparator;

/**
 *
 * @author martins
 */
public interface DetailedAlignment extends Comparable, Alignment
{    
    public abstract int     getQueryStart();
    public abstract int     getQueryEnd();
    public abstract int     getQuerySize();
    public abstract String  getQueryName();
    public abstract int     getTargetStart();
    public abstract int     getTargetEnd();
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
    
    public static Comparator<DetailedAlignment> compareByQueryAlignmentLength = new Comparator<DetailedAlignment>(){
        public int compare(DetailedAlignment alignment1, DetailedAlignment alignment2) {
            int queryLength1 = Math.abs(alignment1.getQueryEnd() - alignment1.getQueryStart());
            int queryLength2 = Math.abs(alignment2.getQueryEnd() - alignment2.getQueryStart());
            return queryLength2 - queryLength1;
        }
    };
    
    public static Comparator<DetailedAlignment> compareByQueryName = new Comparator<DetailedAlignment>(){
        public int compare(DetailedAlignment alignment1, DetailedAlignment alignment2) {
            return alignment1.getQueryName().compareTo(alignment2.getQueryName());
        }
    };
    
    public static boolean overlapByQuery(DetailedAlignment alignment1, DetailedAlignment alignment2)
    {
        if(alignment1.getQueryStart() > alignment2.getQueryEnd() || alignment2.getQueryStart() > alignment1.getQueryEnd())
        {
            return false;
        }
        return true;
    }
       
}