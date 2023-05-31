public class Location
{
    //Implement the Location class here
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    
    public boolean hasShip;
    private int status;
    
    public Location()
    {
        status = UNGUESSED;
    }
    
    public boolean checkHit()
    {
        if(status == HIT)
        {
            return true;
        }
        return false;
    }
    
    public boolean checkMiss()
    {
        if(status == MISSED)
        {
            return true;
        }
        return false;
    }
    
    public boolean isUnguessed()
    {
        if(status == UNGUESSED)
        {
            return true;
        }
        return false;
    }
    
    public void markHit()
    {
        status = HIT;
    }
    
    public void markMiss()
    {
        status = MISSED;
    }
    
    public boolean hasShip()
    {
        if(hasShip == true)
        {
            return true;
        }
        return false;
    }
    
    public void setShip(boolean val)
    {
        hasShip = true;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public int getStatus()
    {
        return status;
    }
}
