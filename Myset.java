import java.util.*;
import java.io.*;
import java.lang.*;

@SuppressWarnings("unchecked")

public class Myset {
	
	public int count = 0;
	public LinkedList<Exchange> list = new LinkedList<Exchange>(); //can use Myset<T>
	
	public Boolean IsEmpty(){
		if(count==0){return true;}
		else return false;
	};
	
	public void setCount(int count){ //Should be used in emergency only /////DANGER/////
		this.count = count;
	}
	public Boolean IsMember(Exchange o){
		if(this.list.contains(o)){
			return true;
		} else return false;
	}
	
	public void Insert(Exchange o){
		this.count += 1;
		this.list.add(o);
	}
	
	public int showCount(){
		return this.count;
	}

	public Exchange showElement(int i){
		// MobilePhone g1 = new MobilePhone();
		// g1 = (MobilePhone)this.list.get(i);
		// System.out.println(g1.number() + " : " + g1.status());

		return this.list.get(i);
	}

	public LinkedList showAll(){
		return this.list;
	}

	public void Delete(Object o){
		try{
			this.list.remove(o);
		} catch(Exception e){ //Exception not working now
			System.out.println("NotFound");
		}
	}
	
	public LinkedList Union(Myset a){ //Ideally according to assignment, the return type should be Myset
		Myset temp1 = new Myset();
		//Myset temp2 = new Myset();
		temp1.list = a.list;
		for(int i=0;i<this.list.size();i++){
			if(!temp1.list.contains(this.list.get(i))){
				temp1.list.add(this.list.get(i));
			}
		}
		//b.addAll(this.list);
		//System.out.println(b.list);
		return temp1.list;
	}
	
	public LinkedList Intersection(Myset a){
		Myset temp2 = new Myset();
		temp2.list = a.list;
		Myset temp3 = new Myset();
		temp3.list = this.list;
		for(int j=0;j<temp3.list.size();j++){
			if(!temp2.list.contains(temp3.list.get(j))){
				//temp2.list.remove(this.list.get(i));//remove from Myset a
				temp3.list.remove(temp3.list.get(j));//remove fromm the copy of this
			}
		}
		for(int k=0;k<temp2.list.size();k++){
			if(!temp3.list.contains(temp2.list.get(k))){
				temp2.list.remove(temp2.list.get(k));
			}
		}
		return temp2.list;
	}
	
	// public static void main(String[] args) throws ExchangeNotFoundException, LinkedListOutofBoundsException, EmptySetException, MobileNotFoundException, MobileSwitchedOffException, NotHavingChildrenExchangeException, IndexOutOfBoundsException, NotABaseStationException{
	// 	//Object[] ob={"Karan","Tanwar"};
	// 	//Myset One = new Myset();
	// 	// Examples(){	
	// 	// 	//One.Insert("Karan");
	// 	// 	//One.Insert("Lakshay");
	// 	// 	//One.Insert("Shubham");
	// 	// 	//System.out.println(One);
	// 	// 	//Myset Two = new Myset();
	// 	// 	//Two.Insert("Harsh");
	// 	// 	//System.out.println(One.Union(Two));
	// 	// 	//System.out.println(One.Intersection(Two));
	// 	// 	//One.Union(Two);
	// 	// 	//System.out.println(One.list);
	// 	// 	//System.out.println(One.list.get(0));//list.get() isused to get the ith data same as array[2]
	// 	// 	//System.out.println(a.IsMember(name));
	// 	// 	//System.out.println(One.IsEmpty());
	// 	// 	// a.Delete("Karan");
	// 	// 	// System.out.println(a.IsMember(name));
	// 	// 	//a.Delete(name);//Just checking the exception if its working :/
	// 	// 	// MobilePhoneSet set1 = new MobilePhoneSet();
	// 	// 	// MobilePhone phone1 = new MobilePhone(23);
	// 	// 	// MobilePhone phone2 = new MobilePhone(24);
	// 	// 	// phone1.status = true;
	// 	// 	// set1.InsertMobile(phone1, One);
	// 	// 	// set1.InsertMobile(phone2, One);
	// 	// 	// //System.out.println(One.list.get(0).number() + " " + One.list.get(1).number());
	// 	// 	// //System.out.println(One.list.get(1).switchedOff());
	// 	// 	// System.out.println(phone2.status());
	// 	// }
		
	// 	// Exchange root = new Exchange(0,0);
	// 	// RoutingMapTree tree = new RoutingMapTree(0,root);
	// 	// RoutingMapTree tree = new RoutingMapTree();
	// 	// Exchange e1 = new Exchange(2134,1);
	// 	// Exchange e2 = new Exchange(1732,1);
	// 	// Exchange e3 = new Exchange(1422,2);
	// 	// Exchange e4 = new Exchange(1421,2);
	// 	// tree.create_root_children(e1);
	// 	// tree.create_root_children(e2);
	// 	// tree.create_general_children(e2,e3);
	// 	// tree.create_general_children(e2,e4);
	// 	// MobilePhone ph1 = new MobilePhone(7823);
	// 	// MobilePhone ph2 = new MobilePhone(5111);
	// 	// e3.createChildrenMobile(ph1);
	// 	// e3.createChildrenMobile(ph2);
	// 	// System.out.println(e3.residentSet().getMobilePhone(0));
	// 	RoutingMapTree tree = new RoutingMapTree();
	// 	tree.addExchange(0,1);
	// 	tree.addExchange(0,2);
	// 	tree.addExchange(0,3);
	// 	tree.queryNthChild(0,0);
	// 	tree.queryNthChild(0,2);
	// 	tree.addExchange(1,4);
	// 	tree.addExchange(1,5);
	// 	tree.addExchange(2,6);
	// 	tree.addExchange(2,7);
	// 	tree.addExchange(2,8);
	// 	tree.addExchange(3,9);
	// 	tree.queryNthChild(2,0);
	// 	tree.queryNthChild(3,0);
	// 	tree.switchOnMobile(989,4);
	// 	tree.switchOnMobile(876, 4);
	// 	tree.queryMobilePhoneSet(4);
	// 	tree.queryMobilePhoneSet(1);
	// 	tree.switchOnMobile(656, 5);
	// 	tree.switchOnMobile(54, 5);
	// 	tree.queryMobilePhoneSet(1);
	// 	tree.switchOffMobile (656);
	// 	tree.queryMobilePhoneSet (1);
	// 	tree.switchOnMobile(213, 6);
	// 	tree.switchOnMobile(568, 7);
	// 	tree.switchOnMobile(897, 8);
	// 	tree.switchOnMobile(295, 8);
	// 	tree.switchOnMobile(346, 9);
	// 	tree.queryMobilePhoneSet(0);

	// }

}
