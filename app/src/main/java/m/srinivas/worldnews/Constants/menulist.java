package m.srinivas.worldnews.Constants;

import java.util.ArrayList;

import m.srinivas.worldnews.Activities.Category;
import m.srinivas.worldnews.Adapters.ExpandableListAdapter;
import m.srinivas.worldnews.Models.Agri_Items;
import m.srinivas.worldnews.Models.Home_Items;
import m.srinivas.worldnews.Models.Items;
import m.srinivas.worldnews.R;

/**
 * Created by srinivas on 03/02/18.
 */

public class menulist {

    ArrayList<ExpandableListAdapter.Item> data;
    ArrayList<Items> items;
    ArrayList<Home_Items> home_items;
    ArrayList<Agri_Items> agri_items;
    ArrayList<Cat> categories;
    public menulist() {
        items = new ArrayList<Items>();
        data = new ArrayList<ExpandableListAdapter.Item>();
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "My Account"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "profile"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Refer & Earn"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "desi Cow Milk"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "A2 MILK"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Natural Farming Food"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Rice"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Vegetables"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Fruits"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Wheat"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Pulses"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Spices"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Daily Basket"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Weekly Basket"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Monthly Basket"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "COLD PRESSED OIL"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Rice"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Vegetables"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Fruits"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Wheat"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Pulses"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Spices"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Daily Basket"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Coconut"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Rice"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Vegetables"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Fruits"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Wheat"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Pulses"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Spices"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Daily Basket"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Til / Sesame"));

        items.add(new Items("Agriculture","Rice is grown in States like Punjab, Karnataka, Kerala, Andhra Pradesh and West Bengal. ","single","Rs 11550","Rs 1650", R.drawable.agri));
        items.add(new Items("Agriculture Machinery","Rice is grown in States like Punjab, Karnataka, Kerala, Andhra Pradesh and West Bengal.","single","Rs 11550","Rs 1650",R.drawable.agri_mach));
        items.add(new Items("Aquaculture","Aquaculture is the farming of aquatic organisms such as fish, shellfish and even plants","single","Rs 1550","Rs 650", R.drawable.aqua));
        items.add(new Items("Horticulture","A Dragon Fruit Tree is basically a cactus vine of the genus Hylocereus.","bulk","Rs 350","Rs 150",R.drawable.dragonfruit));
        items.add(new Items("Irrigation","Irrigation is the replacement or supplementation of rainwater with another source of water.","bulk","Rs 350","Rs 150",R.drawable.irrigation));
        items.add(new Items("Kitchen Garden","Growing of fruits, vegetables, flowers in the available space around bunglow, galleries of flats, open terraces, windows wherever the sun light gets to plants.","single","Rs 11,055","Rs 1650",R.drawable.kitchenwaste));
        items.add(new Items("Organic Farming","Composting is the natural process of 'rotting' or decomposition of organic matter by microorganisms under controlled conditions.","bulk","Rs 350","Rs 150",R.drawable.dubia));
        items.add(new Items("Pulp Plants","Silvicultural characters:It is drought resistant and frost hardy. It is also a light demander.","bulk","Rs 350","Rs 150",R.drawable.seri));
        items.add(new Items("Sericulture","Watches for Men 50% off","single","Rs 11,550","Rs 1650",R.drawable.teak));
        items.add(new Items("Timber plants","Rough T-shirt Awesome Product Varities","bulk","Rs 350","Rs 150",R.drawable.tissue));
        items.add(new Items("Tissue culture","Rough T-shirt Awesome Product Varities","bulk","Rs 350","Rs 150",R.drawable.agri));
        items.add(new Items("Agriculture","Rough T-shirt Awesome Product Varities","bulk","Rs 350","Rs 150",R.drawable.dragonfruit));
        items.add(new Items("Agriculture","Rough T-shirt Awesome Product Varities","bulk","Rs 350","Rs 150",R.drawable.dubia));

        home_items = new ArrayList<Home_Items>();
        home_items.add(new Home_Items(R.drawable.home_brown, "Home"));
        home_items.add(new Home_Items(R.drawable.contract, "Contract Farming"));
        home_items.add(new Home_Items(R.drawable.milkdairy, "Milk Dairy"));
        home_items.add(new Home_Items(R.drawable.hostel, "Animal Hostels"));
        home_items.add(new Home_Items(R.drawable.training, "Training"));
        home_items.add(new Home_Items(R.drawable.machineryonhire, "Machinery on Hire"));
        home_items.add(new Home_Items(R.drawable.marketworld_home, "Agri Market World"));
        home_items.add(new Home_Items(R.drawable.createforest, "Create Forest"));
        home_items.add(new Home_Items(R.drawable.yellowpages, "Agri Yellow Pages"));
        home_items.add(new Home_Items(R.drawable.franchise, "Franchisees"));
        home_items.add(new Home_Items(R.drawable.services, "Services"));
        home_items.add(new Home_Items(R.drawable.shareapp, "Share App"));
        home_items.add(new Home_Items(R.drawable.logout, "Logout"));

        categories = new ArrayList<Cat>();
        categories.add(new Cat("Fruits"));
        categories.add(new Cat("Vegetables"));
        categories.add(new Cat("Milk"));
        categories.add(new Cat("Water"));
        categories.add(new Cat("Organic Store"));
        categories.add(new Cat("HomeCare"));
        categories.add(new Cat("KitchenWare"));
        categories.add(new Cat("Personalcare"));
        categories.add(new Cat("Brands"));
        categories.add(new Cat("Food Grains"));
        categories.add(new Cat("Oils"));
        categories.add(new Cat("Masala"));
        categories.add(new Cat("HouseHolds"));
        categories.add(new Cat("Agriculture"));
        categories.add(new Cat("Agriculture Machinery"));
        categories.add(new Cat("Aquaculture"));
        categories.add(new Cat("Horticulture"));
        categories.add(new Cat("Irrigation"));
        categories.add(new Cat("Kitchen Garden"));
        categories.add(new Cat("Organic Farming"));
        categories.add(new Cat("Pulp Plants"));
        categories.add(new Cat("Sericulture"));
        categories.add(new Cat("Timber Plants"));
        categories.add(new Cat("Tissue culture"));

        agri_items = new ArrayList<Agri_Items>();
        agri_items.add(new Agri_Items(R.drawable.agri,"Agriculture"));
        agri_items.add(new Agri_Items(R.drawable.agri_mach,"Agri Machinery"));
        agri_items.add(new Agri_Items(R.drawable.aqua,"Aqua"));
        agri_items.add(new Agri_Items(R.drawable.dragonfruit,"Dragon Fruit"));
        agri_items.add(new Agri_Items(R.drawable.irrigation,"Irrigation"));
        agri_items.add(new Agri_Items(R.drawable.kitchenwaste,"Kitchen Waste"));
        agri_items.add(new Agri_Items(R.drawable.dubia,"Dubia"));
        agri_items.add(new Agri_Items(R.drawable.seri,"Seri"));
        agri_items.add(new Agri_Items(R.drawable.teak,"Teak"));
        agri_items.add(new Agri_Items(R.drawable.tissue,"Tissue"));
        agri_items.add(new Agri_Items(R.drawable.agri,"Agriculture"));
        agri_items.add(new Agri_Items(R.drawable.dragonfruit,"Agriculture"));
        agri_items.add(new Agri_Items(R.drawable.dubia,"Agriculture"));

    }

    public ArrayList<ExpandableListAdapter.Item> senddata() {
        return data;
    }

    public ArrayList<Items> sendItems(){
        return items;
    }

    public ArrayList<Home_Items> sendhome(){
        return  home_items;
    }
    public ArrayList<Cat> sendcats(){
        return categories;
    }
    public ArrayList<Agri_Items> sendagri(){
        return agri_items;
    }
}
