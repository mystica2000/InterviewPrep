import java.io.*;
public class LinkedList {
    class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    public void insert_at_end(int data)
    {
        if(head==null)
        {
            head=new Node(data);
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=new Node(data);
        }
    }
    public void insert_at_start(int data)
    {
        if(head==null)
        {
            head=new Node(data);
        }
        else
        {
            Node front=new Node(data);
            front.next=head;
            head=front;
        }
    }
    public void insert_at_pos(int data,int pos)
    {
        if(head==null && pos>1)
        {
            System.out.println("Linked List is Empty \n pos is not valid");
            return;
        }
        else
        {
            if(head==null)
            {
                head=new Node(data);
            }
            else
            {
                if(pos==0)
                {
                    insert_at_start(data);
                }
                else
                {
                try{    
                Node temp=head;
                Node cur=null;
                while(pos!=1 && temp!=null)
                {
                    temp=temp.next;
                    pos--;
                }
                cur=temp.next;
                temp.next=new Node(data);
                temp=temp.next;
                temp.next=cur;
                }
                catch(Exception e)
                {
                    System.out.println("Pos is Out of Bound");
                    System.out.println("Inserting at end");
                    insert_at_end(data);
                }
            }
        }
    }
    }
    public void delete_at_start()
    {
        if(head==null)
        {
            System.out.println("Linked List is Empty");
            return;
        }
        else
        {
            head=head.next;
        }
    }
    public void delete_at_end()
    {
        if(head==null)
        {
            System.out.println("Linked List is Empty");
            return;
        }
        if(head.next==null)
        {
            head=null;
        }
        else
        {
            Node temp=head;
            Node ref=temp;
            while(temp!=null && temp.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next=null;
            head=ref;
        }
    }
    public void delete_at_pos(int pos)
    {
        if(head==null)
        {
            System.out.println("Nothing to delete");
            return;
        }
        else
        {
            if(pos==0)
            {
                delete_at_start();
            }
            else
            {
                try{
                Node temp=head;
                Node restore=temp;
                while(pos!=1 && temp.next!=null)
                {
                    temp=temp.next;
                    pos--;
                }
                temp.next=temp.next.next;
                head=restore;
                }
                catch(Exception e)
                {
                    System.out.println("Index Out of Bounds");
                }
            }
        }
    }
    public void search(int key)
    {
        if(head==null)
        {
            System.out.println("No elements in linked list");
            return;
        }
        else
        {
            if(head.data==key)
            {
                System.out.println("Found at index 0");
            }
            else
            {
                Node temp=head;
                int index=0;
                while(temp.next!=null && temp.data!=key)
                {
                    temp=temp.next;
                    index++;
                }
                if(temp!=null && temp.data!=key)
                {
                    System.out.println("Not Found");
                }
                else{
                System.out.println("Found at Index "+index);
                }

            }
        }
    }
    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" => ");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    public static void main(String args[])
    {
     LinkedList list=new LinkedList();
     /*
       Testing insertion at the end
      */
       list.insert_at_end(5);   
      list.insert_at_end(10);   
      list.insert_at_end(20);   
      list.insert_at_end(40);   
      list.display();
     /*
      Testing insertion at front
      */
      list.insert_at_start(5);
      list.insert_at_start(10);
      list.insert_at_start(20);
      list.insert_at_start(40);
      list.insert_at_start(60);
      list.display();
       /*
      Testing insertion at specific pos
       */
      list.insert_at_pos(5,0);
      list.insert_at_pos(2,1);
      list.insert_at_pos(10,2);
      list.insert_at_pos(50,0);
      list.insert_at_pos(100,2);
      list.display();  
      /* 
       Deleting at start
       */
       list.delete_at_start();
       list.delete_at_start();
       list.delete_at_start();
       list.delete_at_start();
       list.delete_at_start();
       list.display();
       /*
        Deleting at end
        */
        list.delete_at_end();
        list.delete_at_end();
        list.delete_at_end();
        list.delete_at_end();
        list.delete_at_end();
        list.display();
        list.delete_at_pos(1);
           list.search(10);
          list.display();
    }
}