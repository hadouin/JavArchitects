package fr.isep.javarchitects.utils;

import fr.isep.javarchitects.core.Material;

import java.util.HashMap;

public class ImmutableMaterialCardByTypeCounts {

	public final int woodCount;
	public final int paperCount;
	public final int brickCount;
	public final int stoneCount;
	public final int glassCount;
	public final int goldCount;
	
	public int getTotalCount() {
		return woodCount +  paperCount + brickCount + stoneCount + glassCount + goldCount;
	}

	// ------------------------------------------------------------------------
	
	public static Builder builder() {
		return new Builder();
	}
	
	public ImmutableMaterialCardByTypeCounts(
			int materialWoodCount, int materialPaperCount, int materialBrickCount,
			int materialStoneCount, int materialGlassCount, int materialGoldCount) {
		this.woodCount = materialWoodCount;
		this.paperCount = materialPaperCount;
		this.brickCount = materialBrickCount;
		this.stoneCount = materialStoneCount;
		this.glassCount = materialGlassCount;
		this.goldCount = materialGoldCount;
	}

	protected ImmutableMaterialCardByTypeCounts(Builder b) {
		this.woodCount = b.woodCount;
		this.paperCount = b.paperCount;
		this.brickCount = b.brickCount;
		this.stoneCount = b.stoneCount;
		this.glassCount = b.glassCount;
		this.goldCount = b.goldCount;
	}
	
	public ImmutableMaterialCardByTypeCounts(ImmutableCardByTypeCounts src) {
		this.woodCount = src.materialWoodCount;
		this.paperCount = src.materialPaperCount;
		this.brickCount = src.materialBrickCount;
		this.stoneCount = src.materialStoneCount;
		this.glassCount = src.materialGlassCount;
		this.goldCount = src.materialGoldCount;
	}

	// ------------------------------------------------------------------------
	
	public int get(Material material) {
		switch(material) {
		case Wood: return woodCount;
		case Paper: return paperCount;
		case Brick: return brickCount;
		case Stone: return stoneCount;
		case Glass: return glassCount;
		case Gold: return goldCount;
		default: throw new IllegalStateException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ImmutableMaterialCardByTypeCounts that = (ImmutableMaterialCardByTypeCounts) o;
		return woodCount == that.woodCount &&
				paperCount == that.paperCount &&
				brickCount == that.brickCount &&
				stoneCount == that.stoneCount &&
				glassCount == that.glassCount &&
				goldCount == that.goldCount;
	}

	public int getUniqueTotal() {
		int count = 0;
		if (this.woodCount > 0){
			count++;
		};
		if (this.paperCount > 0){
			count++;
		};
		if (this.brickCount > 0){
			count++;
		};
		if (this.stoneCount > 0){
			count++;
		};
		if (this.glassCount > 0){
			count++;
		};
		if (this.goldCount > 0){
			count++;
		};
		return count;
	}

	public HashMap<Material, Integer> getHashMap(){
		// Create a hashmap that contains unique cards and their number of occurrence
		HashMap<Material, Integer> map = new HashMap<>();
		for (Material material : Material.values()) {
			if (this.get(material) > 0){
				map.put(material, this.get(material));
			}
		}
		return map;
	}

	// ------------------------------------------------------------------------
	
	public static class Builder {
		public int woodCount;
		public int paperCount;
		public int brickCount;
		public int stoneCount;
		public int glassCount;
		public int goldCount;

		public Builder() {
		}
		public Builder(Builder src) {
			this.woodCount = src.woodCount;
			this.paperCount = src.paperCount;
			this.brickCount = src.brickCount;
			this.stoneCount = src.stoneCount;
			this.glassCount = src.glassCount;
			this.goldCount = src.goldCount;
		}
		
		public ImmutableMaterialCardByTypeCounts build() {
			return new ImmutableMaterialCardByTypeCounts(this);
		}

		public Builder with(Material material, int count) {
			switch(material) {
			case Wood: this.woodCount = count; break;
			case Paper: this.paperCount = count; break;
			case Brick: this.brickCount = count; break;
			case Stone: this.stoneCount = count; break;
			case Glass: this.glassCount = count; break;
			case Gold: this.goldCount = count; break;
			default: throw new IllegalStateException();
			} 
			return this;
		}

		public Builder cloneBuilderWithSelect(Material material) {
			return new Builder(this).with(material, 1);
		}

		public Builder add(Material material) {
			switch (material) {
				case Wood -> this.woodCount++;
				case Paper -> this.paperCount++;
				case Brick -> this.brickCount++;
				case Stone -> this.stoneCount++;
				case Glass -> this.glassCount++;
				case Gold -> this.goldCount++;
				default -> throw new IllegalStateException();
			}
			return this;
		}
	}
	
}
