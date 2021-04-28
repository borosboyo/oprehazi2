
public class Frame {
    String name;
    int lock = 0;
    int number;
    int useTime;

    public Frame(String _name, int _lock){
        name = _name;
        lock = _lock;
        number = 0;
        useTime = 0;
    }

    public boolean hasLock(){
        if(lock > 0)
            return true;
        else{
            return false;
        }
    }

    public String getName(){
        return name;
    }

    public void putValue(int _number){
        number = _number;
        lock = 4;
        useTime = 0;
    }

    public void decreaseLock(){
        if(lock > 0)
            lock--;
    }

    public int getLock(){
        return lock;
    }


    public int getNumber() {
        return number;
    }

    public int getUseTime() {
        return useTime;
    }

    public void increaseUseTime(){
        useTime++;
    }

    public void setUseTime(int _useTime){
        useTime = _useTime;
    }

    public void setLock(int _lock){
        lock = _lock;
    }
}
