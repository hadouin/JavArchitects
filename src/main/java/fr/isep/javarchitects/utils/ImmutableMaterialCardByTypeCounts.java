package fr.isep.javarchitects.utils;

import fr.isep.javarchitects.core.Material;

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
	}
	
}
