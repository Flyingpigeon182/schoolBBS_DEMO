package com.example.tree_demo.DTO;

import java.util.*;

import static com.example.tree_demo.controller.SendSet.sendset;

public class treeprinter {
    static int floor;
    static String[] input;
    static int width,height,posx,posy,pos;
    final static int elementwriteoffset=5;
    static char[][] map;
    public static boolean legaltree;
    public static Set<nodeclass> nodelist;
    public static Set<lineclass> linelist;
    static class node{
        String info;
        node left;
        node right;
        int fl;
        node(String i,int f){
            if(f>floor)floor=f;
            info=i;
            fl=f;
            left=null;
            right=null;
        }
        node(){}
    }

    static node spawntreeStack(String[] input) {
        legaltree=true;
        Stack<node> node_stack = new Stack<node>();
        Stack<Integer> status_stack = new Stack<Integer>();
        // put the first root element
        node root = new node(input[0], 1);
        node_stack.push(root);
        status_stack.push(0);  // 0 - consider the left child of corresspnd node, 1- consider the right

        for (int i = 1; i < input.length; i++) {
            if(status_stack.empty()||node_stack.empty()){
                legaltree=false;
                System.out.println(floor+" "+false);
                return root;
            }
            int status = status_stack.peek();
            if (input[i].equals("#")){
                if (status == 0) {
                    status_stack.pop();
                    status_stack.push(1);
                } else {
                    status_stack.pop();
                    node_stack.pop();
                }
            } else {
                node father = node_stack.peek();
                node target  = new node(input[i], father.fl + 1);
                if (status == 0) {
                    father.left = target;
                    status_stack.pop();
                    status_stack.push(1);
                } else {
                    father.right = target;
                    status_stack.pop();
                    node_stack.pop();
                }
                node_stack.push(target);
                status_stack.push(0);
            }
        }
        if(!(status_stack.empty()&&node_stack.empty()))legaltree=false;
        System.out.println(floor+" "+legaltree);
        return root;
    }
    static void printtreewithoutformat(node i){
        if(i==null)return;
        System.out.println(i.info+" "+i.fl);
        printtreewithoutformat(i.left);
        printtreewithoutformat(i.right);
    }
    static void initmap(){
        nodelist=new HashSet<>();
        linelist=new HashSet<>();
        width=(int)Math.pow(2,floor)-3+2*elementwriteoffset;
        height=(int)Math.pow(2,floor-1);
        posx=width/2+1;
        posy=0;
        pos=0;
        map=new char[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++)map[i][j]=' ';
        }
        System.out.println("map inited:");
        System.out.println("height:"+height);
        System.out.println("width:"+width);
        System.out.println("corrent x position:"+posx);
        System.out.println("corrent y position:"+posy+'\n');
    }
    static void insertelement(String element){//用来写二叉树的节点的值。注意：因为叶子节点留的空比较窄所以只允许两位数，也就是element.length()<=2
        System.out.println("current position:("+posx+','+posy+')');
        int length=element.length();
        int x=(int)(posx-length/2);
        for(int i=0;i<length;i++)map[posy][i+x]=element.charAt(i);
        System.out.println("inserted:"+element+'\n');
    }
    static void moveforward(boolean dir,int f){
        int step=(int)Math.pow(2,floor-f)-1;
        int k1=posx*100,o1=f*200;
        char fill=(dir)?'/':'\\';
        for(int i=0;i<step;i++){
            posy++;
            posx+=(dir)?-1:1;
            map[posy][posx]=fill;
        }
        posy++;
        posx+=(dir)?-1:1;
        int k2=posx*100,o2=(f+1)*200;
        linelist.add(new lineclass(k1,o1-200,k2,o2-200));
    }
    static void moveback(boolean dir,int f){
        int step=(int)Math.pow(2,floor-f);
        posy-=step;
        posx-=((dir)?-1:1)*step;
    }
    static void printtreewithformat(node root){
        initmap();
        printtreewithformatbody(true,root,true);
        printmap();
    }
    static void printtreewithformatbody(Boolean dir,node r,Boolean isfirst){
        if(r==null)return;
        if(!isfirst)moveforward(dir,r.fl);
        System.out.println("current node:"+'('+dir+','+r.info+','+r.fl+')');
        nodelist.add(new nodeclass(posx*100,r.fl*200,r.info));
        insertelement(r.info);
        printtreewithformatbody(true,r.left,false);
        printtreewithformatbody(false,r.right,false);
        moveback(dir,r.fl);
    }
    static void printmap(){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++)System.out.print(map[i][j]);
            System.out.println();
        }
    }

    public static class nodeclass{
        public int x;
        public int y;
        public String i;
        nodeclass(int x,int y,String i){
            this.x=x;
            this.y=y;
            this.i=i;
        }
    }
    public static class lineclass{
        public int x1;
        public int y1;
        public int x2;
        public int y2;
        lineclass(int x1,int y1,int x2,int y2){
            this.x1=x1;
            this.y1=y1;
            this.x2=x2;
            this.y2=y2;
        }
    }
    public static String treestring(String treestring)
    {
        System.out.println(treestring);
        List<String> temp = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treestring.length(); i++)
        {
            if (treestring.charAt(i) != '_') sb.append(treestring.charAt(i));
            else {
                temp.add(sb.toString());
                System.out.println("getelement:"+sb.toString());
                sb = new StringBuilder();
            }
        }
        int length=temp.size();
        input=new String[length];
        System.out.println("arraysize:"+length);
        Iterator a=temp.iterator();
        for (int i = 0; i < input.length; i++) {
            input[i]=(String)a.next();
            System.out.println("input["+i+"]:"+input[i]);
        }
        dobody();
        return "success";
    }
    public static void reset(){
        input=new String[0];
        floor=0;
        posx=0;
        posy=0;
        map=new char[0][0];
        pos=0;
    }
    public static void dobody(){

        floor=0;
        node root=spawntreeStack(input);
        System.out.println(legaltree);

        if(legaltree) {
            printtreewithoutformat(root);
            printtreewithformat(root);
            sendset();
        }
        reset();
        //sendstatus(legaltree);
    }
}
