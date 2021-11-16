package model.dialogs;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.MouseMode;
import model.interfaces.UserChoices;
import model.interfaces.DialogProvider;
import view.interfaces.DialogChoice;

public class DialogProviderImpl implements DialogProvider {
    private final DialogChoice<ShapeType> chooseShapeDialog;
    private final DialogChoice<ShapeColor> choosePrimaryColorDialog;
    private final DialogChoice<ShapeColor> chooseSecondaryColorDialog;
    private final DialogChoice<ShapeShadingType> chooseShadingTypeDialog;
    private final DialogChoice<MouseMode> chooseStartAndEndPointModeDialog;

  public DialogProviderImpl(UserChoices applicationState) {
    chooseShapeDialog = new ChooseShapeDialog(applicationState);
        choosePrimaryColorDialog = new ChoosePrimaryColorDialog(applicationState);
        chooseSecondaryColorDialog = new ChooseSecondaryColorDialog(applicationState);
        chooseShadingTypeDialog = new ChooseShadingTypeDialog(applicationState);
        chooseStartAndEndPointModeDialog = new ChooseStartAndEndPointModeDialog(applicationState);
    }

    @Override
    public DialogChoice<ShapeType> getChooseShapeDialog() {
        return chooseShapeDialog;
    }

    @Override
    public DialogChoice<ShapeColor> getChoosePrimaryColorDialog() {
        return choosePrimaryColorDialog;
    }

    @Override
    public DialogChoice<ShapeColor> getChooseSecondaryColorDialog() {
        return chooseSecondaryColorDialog;
    }

    @Override
    public DialogChoice<ShapeShadingType> getChooseShadingTypeDialog() {
        return chooseShadingTypeDialog;
    }

    @Override
    public DialogChoice<MouseMode> getChooseStartAndEndPointModeDialog() {
        return chooseStartAndEndPointModeDialog;
    }
}
