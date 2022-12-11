package kz.altyn.komek;

import java.util.ArrayList;
import java.util.List;

import kz.altyn.komek.models.Package;
import kz.altyn.komek.models.Product;

public class ProductHelper {

    private final Product rice = new Product("Kúrish", 40, R.drawable.chal, 1, "Kg");
    private final Product peas = new Product("Burshaq", 80, R.drawable.dhal, 1, "Kg");
    private final Product soap = new Product("Sabyn", 35, R.drawable.soap, 1, "P");
    private final Product oil = new Product("Mai (5 L)", 570, R.drawable.tell, 1, "P");
    private final Product potato = new Product("Kartop", 40, R.drawable.alu, 1, "Kg");
    private final Product salt = new Product("Tuz", 29, R.drawable.salt, 1, "Kg");
    private final Product onion = new Product("Pıaz", 89, R.drawable.peyaj, 1, "Kg");
    private final Product antiseptic = new Product("Antiseptic", 32, R.drawable.savlon, 1, "Kg");
    private final Product toiletTissue = new Product("Dárethana qaǵazy", 25, R.drawable.tisu, 1, "P");
    private final Product hairOil = new Product("Sýsabyn", 115, R.drawable.hair, 1, "P");
    private final Product toothpaste = new Product("Tis pastasy", 180, R.drawable.toothpaste, 1, "P");
    private final Product brash = new Product("Tis shetkasy", 80, R.drawable.brash, 1, "P");
    private final Product towel = new Product("Súlgi", 160, R.drawable.gamcha, 1, "P");
    private final Product lotion = new Product("Ylǵaldandyratyn losón", 360, R.drawable.babylo, 1, "P");
    private final Product feeder = new Product("Nárestelerdi tamaqtandyrǵysh", 295, R.drawable.feeder, 1, "P");
    private final Product babyShampoo = new Product("Balalarǵa arnalǵan sýsabyn", 475, R.drawable.bshampo, 1, "P");
    private final Product babyDiaper = new Product("Balalarǵa arnalǵan jórgek", 899, R.drawable.dyper, 1, "P");



    public List<Package> initHelpPackage() {
        List<Package> allProductPackageList = new ArrayList<>();
        Package helpPackage1 = coronaHelpPackage();
        allProductPackageList.add(helpPackage1);
        Package helpPackage2 = groceryPackage();
        allProductPackageList.add(helpPackage2);
        Package helpPackage3 = hygienePackage();
        allProductPackageList.add(helpPackage3);
        Package helpPackage4 = babyCarePackage();
        allProductPackageList.add(helpPackage4);
        return allProductPackageList;
    }

    private Package babyCarePackage() {
        List<Product> helpPackage4ProductList = new ArrayList<>();
        lotion.setQuantity(1);
        feeder.setQuantity(1);
        babyShampoo.setQuantity(1);
        babyDiaper.setQuantity(1);

        helpPackage4ProductList.add(lotion);
        helpPackage4ProductList.add(feeder);
        helpPackage4ProductList.add(babyShampoo);
        helpPackage4ProductList.add(babyDiaper);

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < helpPackage4ProductList.size(); i++) {
            string.append(helpPackage4ProductList.get(i).getName()).append(" ").append(helpPackage4ProductList.get(i).getQuantity()).append(" ").append(helpPackage4ProductList.get(i).getUnit()).append(", ");
        }
        return new Package(helpPackage4ProductList, "Analar men balalarǵa", string.toString(), R.drawable.ic_logo);
    }

    private Package hygienePackage() {
        List<Product> helpPackage3ProductList = new ArrayList<>();
        antiseptic.setQuantity(2);
        toiletTissue.setQuantity(2);
        soap.setQuantity(5);
        hairOil.setQuantity(1);
        toothpaste.setQuantity(1);
        brash.setQuantity(2);
        towel.setQuantity(2);
        helpPackage3ProductList.add(antiseptic);
        helpPackage3ProductList.add(soap);
        helpPackage3ProductList.add(toiletTissue);
        helpPackage3ProductList.add(hairOil);
        helpPackage3ProductList.add(toothpaste);
        helpPackage3ProductList.add(brash);
        helpPackage3ProductList.add(towel);
        StringBuilder efe = new StringBuilder();
        for (int i = 0; i < helpPackage3ProductList.size(); i++) {
            efe.append(helpPackage3ProductList.get(i).getName()).append(" ").append(helpPackage3ProductList.get(i).getQuantity()).append(" ").append(helpPackage3ProductList.get(i).getUnit()).append(", ");
        }
        return new Package(helpPackage3ProductList, "Jeke kútim", efe.toString(), R.drawable.ic_logo);
    }

    private Package groceryPackage() {
        List<Product> helpPackage2ProductList = new ArrayList<>();
        rice.setQuantity(3);
        helpPackage2ProductList.add(rice);
        oil.setQuantity(1);
        helpPackage2ProductList.add(oil);
        salt.setQuantity(1);
        helpPackage2ProductList.add(salt);
        soap.setQuantity(1);
        helpPackage2ProductList.add(soap);
        onion.setQuantity(1);
        helpPackage2ProductList.add(onion);
        peas.setQuantity(1);
        helpPackage2ProductList.add(peas);
        potato.setQuantity(3);
        helpPackage2ProductList.add(potato);
        StringBuilder dfes = new StringBuilder();
        for (int i = 0; i < helpPackage2ProductList.size(); i++) {
            dfes.append(helpPackage2ProductList.get(i).getName()).append(" ").append(helpPackage2ProductList.get(i).getQuantity()).append(" ").append(helpPackage2ProductList.get(i).getUnit()).append(", ");
        }
        return new Package(helpPackage2ProductList, "Ónimder", dfes.toString(), R.drawable.ic_logo);
    }

    private Package coronaHelpPackage() {
        List<Product> helpPackage1ProductList = new ArrayList<>();
        rice.setQuantity(5);
        helpPackage1ProductList.add(rice);
        peas.setQuantity(2);
        helpPackage1ProductList.add(peas);
        onion.setQuantity(2);
        helpPackage1ProductList.add(onion);
        soap.setQuantity(1);
        helpPackage1ProductList.add(soap);
        oil.setQuantity(1);
        helpPackage1ProductList.add(oil);
        potato.setQuantity(5);
        helpPackage1ProductList.add(potato);
        StringBuilder des = new StringBuilder();
        for (int i = 0; i < helpPackage1ProductList.size(); i++) {
            des.append(helpPackage1ProductList.get(i).getName()).append(" ").append(helpPackage1ProductList.get(i).getQuantity()).append(" ").append(helpPackage1ProductList.get(i).getUnit()).append(", ");
        }
        return new Package(helpPackage1ProductList, "Corona kómek qoraby", des.toString(), R.drawable.package1);
    }


}
