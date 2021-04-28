


import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class LRU {

    ArrayList<Frame> frames = new ArrayList<Frame>();
    ArrayList<String> output = new ArrayList<String>();
    int errors = 0;


    public LRU(){
        initList();
    }

    public void run(){
        Scanner sc = new Scanner(System.in).useDelimiter("[,\\s]");
        while(sc.hasNextInt()){
            int input = sc.nextInt();
            if(contains(input)){
                output.add("-");
            }
            else{
                if(isThereNotLocked() == false){
                    output.add("*");
                }
                else{
                    Frame nf;
                    if(isThereEmpty() == true){
                        nf = returnEmpty();
                        nf.putValue(input);
                    }
                    else{
                        nf = returnFrameWithMaxTime();
                        nf.putValue(input);
                    }
                    output.add(nf.getName());
                }
            }
            step();
        }
    }

    public void step(){
        for(int ii = 0; ii < frames.size(); ii++){
            if(frames.get(ii).getNumber() != 0){
                frames.get(ii).increaseUseTime();
                frames.get(ii).decreaseLock();
            }
        }
    }

    public Frame returnFrameWithMaxTime(){
        int frameIndex = 0;
        int max = 0;
        for(int ii = 0; ii < frames.size(); ii++){
            if(!frames.get(ii).hasLock()){
                if(frames.get(ii).getUseTime() > max){
                    max = frames.get(ii).getUseTime();
                    frameIndex = ii;
                }
            }
        }
        return frames.get(frameIndex);
    }

    public Frame returnEmpty(){
        for(int ii = 0; ii < frames.size(); ii++){
            if(!frames.get(ii).hasLock()){
                if(frames.get(ii).getNumber() == 0){
                    return frames.get(ii);
                }
            }
        }
        return null;
    }

    public boolean isThereEmpty(){
        boolean isEmpty = false;
        for(int ii = 0; ii < frames.size(); ii++){
            if(frames.get(ii).getNumber() == 0){
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    public boolean isThereNotLocked(){
        if(!frames.get(0).hasLock() || !frames.get(1).hasLock() || !frames.get(2).hasLock()){
            return true;
        }
        else{
            return false;
        }
    }

    public void initList(){
        frames.add(new Frame("A", 0));
        frames.add(new Frame("B", 0));
        frames.add(new Frame("C", 0));
    }

    public boolean contains(int newInput){
        for(int ii = 0; ii < frames.size(); ii++){
            if(abs(frames.get(ii).getNumber()) == abs(newInput)){
                frames.get(ii).setUseTime(0);
                return true;
            }
        }
        return false;
    }

    public void printOutput(){
        for(int ii = 0; ii < output.size(); ii++){
            System.out.print(output.get(ii));
            if(!output.get(ii).equals("-")){
                if(output.get(ii).equals("A") || output.get(ii).equals("B") || output.get(ii).equals("C") || output.get(ii).equals("*")){
                    errors++;
                }
            }
        }
        System.out.println();
        System.out.print(errors);
    }
}
