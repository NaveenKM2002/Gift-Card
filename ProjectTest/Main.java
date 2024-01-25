/**
 * Main
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * GiftCard
 */
class GiftCard {
        private int cardNo;
        
        private String CardName;
        private float cardAmount;
        private int cardPin;
        private String cardValidity;

        static HashMap<Integer,GiftCard> GiftCardData=new HashMap<>();
        static int CountId=1;
        public int getCardNo() {
            return cardNo;
        }
        public void setCardNo(int cardNo) {
            this.cardNo = cardNo;
        }
        public String getCardName() {
            return CardName;
        }
        public void setCardName(String cardName) {
            CardName = cardName;
        }
        public float getCardAmount() {
            return cardAmount;
        }
        public void setCardAmount(float cardAmount) {
            this.cardAmount = cardAmount;
        }
        public int getCardPin() {
            return cardPin;
        }
        public void setCardPin(int cardPin) {
            this.cardPin = cardPin;
        }
        public String getCardValidity() {
            return cardValidity;
        }
        public void setCardValidity(String cardValidity) {
            this.cardValidity = cardValidity;
        }
        public static HashMap<Integer, GiftCard> getGiftCardData() {
            return GiftCardData;
        }
        public static void setGiftCardData(HashMap<Integer, GiftCard> giftCardData) {
            GiftCardData = giftCardData;
        }
    
}
public class Main {
                private static void printMenu(){
                    System.out.println("\t\t\tWelcome- to Gift Card shop\n");
                    System.out.println("1. To create a Gift Card");
                    System.out.println("2. To Remove a Gift Card");
                    System.out.println("3. To Update a Gift Card");
                    System.out.println("4. To Display a Gift Card");
                    System.out.println("5. To Search a Gift Card");
                    System.out.println("6. To exit a Gift Card");
                    System.out.println("Enter your choice");
                }
                private static void toCreateGiftCard(){
                    System.out.println("\t\t\tWelcome- to Create  Gift Card \n");
                    GiftCard obj=new GiftCard();
                    Scanner s=new Scanner(System.in);
                    obj.setCardNo(GiftCard.CountId);
                    System.out.println("Card No is"+obj.getCardNo());
                    System.out.println("Enter Card Name");
                    obj.setCardName(s.next());
                    System.out.println("Enter Card Amount");
                    obj.setCardAmount(s.nextFloat());
                    System.out.println("Enter Card Pin (only 4 digit pin)");
                    int data=s.nextInt();
                    String str= String.valueOf(data);
                    if(str.length()==4){
                        obj.setCardPin(data);
                    }else{
                        System.out.println("pin should be only 4 digit");
                        return;
                    }
                    

                    System.out.println("Enter Card Validity in dd/mm/yyyy format");
                    obj.setCardValidity(s.next());
                    
                    GiftCard.GiftCardData.put(obj.getCardNo(), obj);
                    GiftCard.CountId++;
                    System.out.println("Successfully created Gift Card \n");
                    toDisplayGiftCard();

                }
                private static void toRemoveGiftCard(){
                    System.out.println("\t\t\tWelcome- to Remove  Gift Card \n");
                    Scanner s=new Scanner(System.in);
                    System.out.println("Enter the gift Card No to be removed");
                    int No=s.nextInt();
                    if(GiftCard.GiftCardData.containsKey(No)){
                        GiftCard.GiftCardData.remove(No);
                        System.out.println("Your Card removed successfully \n");
                        toDisplayGiftCard();
                    }else{
                        System.out.println("This card number does not exists");
                    }
                }
                private static void toUpdateGiftCard(){
                    Scanner s=new Scanner(System.in);
                    System.out.println("\t\t\tWelcome- to Update  Gift Card \n");
                    System.out.println("Enter the Card No to be Updated");
                    int No=s.nextInt();
                    if(GiftCard.GiftCardData.containsKey(No)){
                     System.out.println("1. To update name");
                     System.out.println("2. To update Amount");
                     System.out.println("3. To update pin");
                     System.out.println("4. To update validity");
                     System.out.println("Enter what to be updated");
                     int choice=s.nextInt();
                     switch (choice) {
                        case 1:
                            System.out.println("Enter the name to be updated");
                            GiftCard.GiftCardData.get(No).setCardName(s.next());
                            break;
                        case 2:
                            System.out.println("Enter the Amount to be updated");
                            GiftCard.GiftCardData.get(No).setCardAmount(s.nextFloat());
                            break;
                        case 3:
                            System.out.println("Enter the pin to be updated");
                            GiftCard.GiftCardData.get(No).setCardPin(s.nextInt());
                            break;
                        case 4:
                            System.out.println("Enter the number to be updated");
                            GiftCard.GiftCardData.get(No).setCardValidity(s.next());
                            break;
                     
                        default:
                        System.out.println("Invalid choice");
                            return;
                     }
                     System.out.println("Your Card is updated successfully\n");
                     toDisplayGiftCard();
                    }else{
                        System.out.println("This card number does not exists");
                    }
                    
                }
                private static void toDisplayGiftCard(){
                    System.out.println("\t\t\tWelcome- to Display  Gift Card \n");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                System.out.println("Card No \t Card Name \t Card Amount \t card Pin \t card Validity");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                for(Map.Entry<Integer, GiftCard> obj : GiftCard.GiftCardData.entrySet()){
                 System.out.print(obj.getValue().getCardNo()+"\t\t");   
                 System.out.print(obj.getValue().getCardName()+"\t\t");   
                 System.out.print(obj.getValue().getCardAmount()+"\t\t");   
                 System.out.print(obj.getValue().getCardPin()+"\t\t");   
                 System.out.println(obj.getValue().getCardValidity()+"\t\t");   
                 System.out.println("---------------------------------------------------------------------------------------------------------------");
                
                }

                }
                private static void toSearchGiftCard(){
                    System.out.println("\t\t\tWelcome- to Search Gift Card \n");
                    Scanner s=new Scanner(System.in);
                    System.out.println("Enter the gift Card No to be Searched");
                    int No=s.nextInt();
                    if(GiftCard.GiftCardData.containsKey(No)){
    
                        System.out.println("Card Name is: "+GiftCard.GiftCardData.get(No).getCardName());
                        System.out.println("Card Amount is: "+GiftCard.GiftCardData.get(No).getCardAmount());
                        System.out.println("Card Pin is: "+GiftCard.GiftCardData.get(No).getCardPin());
                        System.out.println("Card Validity is: "+GiftCard.GiftCardData.get(No).getCardValidity());
                       
                    }else{
                        System.out.println("This card number does not exists\n");
                    }
                }

    public static void main(String[] args) {
        while (true) {
            printMenu();
            Scanner s= new Scanner(System.in);
            int choice =s.nextInt();
            
            switch (choice) {
                case 1:
                    toCreateGiftCard();
                    break;
                case 2:
                    toRemoveGiftCard();
                    break;
                case 3:
                    toUpdateGiftCard();
                    break;
                case 4:
                    toDisplayGiftCard();
                    break;
                case 5:
                    toSearchGiftCard();
                    break;
                case 6:
                    System.exit(choice);
                    break;
            
                default:
                    break;
            }
        }
    }
}


