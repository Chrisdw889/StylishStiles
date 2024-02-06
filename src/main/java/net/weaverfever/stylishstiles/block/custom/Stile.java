package net.weaverfever.stylishstiles.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class Stile extends FenceBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public Stile(Properties properties) {
        super(properties);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> pBuilder) {
        super.fillStateContainer(pBuilder);
        pBuilder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        return super.getStateForPlacement(pContext).with(FACING, pContext.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext context) {
        VoxelShape toReturn = super.getCollisionShape(pState, pLevel, pPos, context);
        VoxelShape extra = Block.makeCuboidShape(0, 16, 0, 16, 17, 16);
        toReturn = VoxelShapes.or(toReturn, extra);
        return toReturn;
    }
}
