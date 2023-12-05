package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listings implements Listable {
	
	public HashMap<String,Residential> listings;
	
	
	public Listings() {
		listings = new HashMap<>();
	}

	
	
	@Override
	public HashMap<String, Residential> getListings() {
		// TODO Auto-generated method stub
		return listings;
	}

	@Override
	public Residential getListing(String address) {
		// TODO Auto-generated method stub
		return listings.get(address);
	}

	@Override
	public Set<String> getStreetAddresses() {
		// TODO Auto-generated method stub
		return listings.keySet();
	}

	@Override
	public Collection<Residential> getResidences() {
		// TODO Auto-generated method stub
		return listings.values();
	}

	@Override
	public int getListingCount() {
		// TODO Auto-generated method stub
		return listings.size();
	}

	@Override
	public void addListing(String address, Residential residence) {
		// TODO Auto-generated method stub
		listings.put(address, residence);
	}

}
