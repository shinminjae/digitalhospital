package kr.bit.digitalhsp.mapping.ui;

import kr.bit.digitalhsp.mapping.configuration.SpringContextFactory;
import kr.bit.digitalhsp.mapping.service.MappingService;
import kr.bit.digitalhsp.mapping.service.TranseService;
import kr.bit.digitalhsp.mapping.service.sqlite3.MappingServiceSqlite;
import kr.bit.digitalhsp.mapping.vo.MappingInfo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.springframework.context.ApplicationContext;


public class ImageMappingTranseServerUI extends Composite {

	private ListViewComposit listViewComposit;
	private CanvasComposit picPatientCanvas;
	private Label labelChtTitle;
	private Label labelChtTitleContents;
	private Label labelOcmTitle;
	private Label labelOcmTitleContents;
	private Label labelName;
	private Label labelNameContents;
	private Label labelAge;
	private Label labelAgeContents;
	private Label labelSex;
	private Label labelSexContents;
	private Label labelDep;
	private Label labelDepContents;
	private Label labelMeDevice;
	private Label labelMeDeviceContents;

	private Label labelImageName;
	private Label labelImageNameContents;
	private Label labelImageSaveDtm;
	private Label labelImageSaveDtmContents;

	public Label getLabelImageNameContents() {
		return labelImageNameContents;
	}

	public void setLabelImageNameContents(Label labelImageNameContents) {
		this.labelImageNameContents = labelImageNameContents;
	}

	public Label getLabelImageSaveDtmContents() {
		return labelImageSaveDtmContents;
	}

	public void setLabelImageSaveDtmContents(Label labelImageSaveDtmContents) {
		this.labelImageSaveDtmContents = labelImageSaveDtmContents;
	}

	public Label getLabelOcmTitleContents() {
		return labelOcmTitleContents;
	}

	public void setLabelOcmTitleContents(Label labelOcmTitleContents) {
		this.labelOcmTitleContents = labelOcmTitleContents;
	}

	public Label getLabelNameContents() {
		return labelNameContents;
	}

	public void setLabelNameContents(Label labelNameContents) {
		this.labelNameContents = labelNameContents;
	}

	public Label getLabelAgeContents() {
		return labelAgeContents;
	}

	public void setLabelAgeContents(Label labelAgeContents) {
		this.labelAgeContents = labelAgeContents;
	}

	public Label getLabelSexContents() {
		return labelSexContents;
	}

	public void setLabelSexContents(Label labelSexContents) {
		this.labelSexContents = labelSexContents;
	}

	public Label getLabelDepContents() {
		return labelDepContents;
	}

	public void setLabelDepContents(Label labelDepContents) {
		this.labelDepContents = labelDepContents;
	}

	public Label getLabelMeDeviceContents() {
		return labelMeDeviceContents;
	}

	public void setLabelMeDeviceContents(Label labelMeDeviceContents) {
		this.labelMeDeviceContents = labelMeDeviceContents;
	}

	/**
	 * Create the application window.
	 */

	ApplicationContext ctx = SpringContextFactory.getInstance();

	public ListViewComposit getListViewComposit() {
		return listViewComposit;
	}

	public void setListViewComposit(ListViewComposit listViewComposit) {
		this.listViewComposit = listViewComposit;
	}

	public CanvasComposit getPicPatientCanvas() {
		return picPatientCanvas;
	}

	public void setPicPatientCanvas(CanvasComposit picPatientCanvas) {
		this.picPatientCanvas = picPatientCanvas;
	}

	public Label getLabelChtTitleContents() {
		return labelChtTitleContents;
	}

	public void setLabelChtTitleContents(Label labelChtTitleContents) {
		this.labelChtTitleContents = labelChtTitleContents;
	}

	public void InitUI() {

		Group group = new Group(this, SWT.SHADOW_ETCHED_IN);

		this.listViewComposit = new ListViewComposit(group, SWT.BORDER
				| SWT.V_SCROLL);
		this.listViewComposit.getList().setBounds(0, 0, 224, 429);
		this.picPatientCanvas = new CanvasComposit(group, SWT.NONE);

		this.labelChtTitle = new Label(group, SWT.NONE);
		this.labelChtTitle.setText("차트번호");
		this.labelChtTitle.setBounds(240, 20, 50, 15);

		this.labelChtTitleContents = new Label(group, SWT.NONE);

		labelChtTitleContents.setBounds(300, 20, 100, 15);

		this.labelOcmTitle = new Label(group, SWT.NONE);
		this.labelOcmTitle.setText("내원번호");
		this.labelOcmTitle.setBounds(400, 20, 50, 15);

		this.labelOcmTitleContents = new Label(group, SWT.NONE);

		this.labelOcmTitleContents.setBounds(460, 20, 100, 15);

		this.labelName = new Label(group, SWT.NONE);
		this.labelName.setText("이름");
		this.labelName.setBounds(240, 35, 50, 15);

		this.labelNameContents = new Label(group, SWT.NONE);

		this.labelNameContents.setBounds(300, 35, 100, 15);

		this.labelAge = new Label(group, SWT.NONE);
		this.labelAge.setText("나이");
		this.labelAge.setBounds(400, 35, 50, 15);

		this.labelAgeContents = new Label(group, SWT.NONE);

		this.labelAgeContents.setBounds(460, 35, 50, 15);

		this.labelSex = new Label(group, SWT.NONE);
		this.labelSex.setText("성별");
		this.labelSex.setBounds(240, 50, 50, 15);

		this.labelSexContents = new Label(group, SWT.NONE);
		this.labelSexContents.setBounds(300, 50, 100, 15);

		this.labelDep = new Label(group, SWT.NONE);
		this.labelDep.setText("진료과목");
		this.labelDep.setBounds(400, 50, 50, 15);

		this.labelDepContents = new Label(group, SWT.NONE);

		this.labelDepContents.setBounds(460, 50, 50, 15);

		this.labelMeDevice = new Label(group, SWT.NONE);
		this.labelMeDevice.setText("의료기기명");
		this.labelMeDevice.setBounds(240, 65, 50, 15);

		this.labelMeDeviceContents = new Label(group, SWT.NONE);

		this.labelMeDeviceContents.setBounds(300, 65, 100, 15);

		this.picPatientCanvas.setBounds(230, 80, 405, 299);

		// Label label1
		// Label label2
		// Label label3
		// Label label4

		this.labelImageName = new Label(group, SWT.NONE);
		labelImageName.setText("이미지명");
		labelImageName.setBounds(240, 380, 50, 15);

		this.labelImageNameContents = new Label(group, SWT.NONE);
		labelImageNameContents.setText("316.jpg");
		labelImageNameContents.setBounds(300, 380, 100, 15);

		this.labelImageSaveDtm = new Label(group, SWT.NONE);
		labelImageSaveDtm.setText("이미지 저장 날짜");
		labelImageSaveDtm.setBounds(400, 380, 100, 15);

		this.labelImageSaveDtmContents = new Label(group, SWT.NONE);
		labelImageSaveDtmContents.setText("2012/12/27 13:50");
		labelImageSaveDtmContents.setBounds(500, 380, 110, 15);

		Button CommitBtn = new Button(group, SWT.NONE);
		CommitBtn.setText("Commit");
		CommitBtn.setBounds(230, 420, 100, 50);
		CommitBtn.addMouseListener(new BtnCommitClick(this));

		Button rollbackBtn = new Button(group, SWT.NONE);
		rollbackBtn.setText("RollBack");
		rollbackBtn.setBounds(330, 420, 100, 50);
		rollbackBtn.addMouseListener(new BtnRollBackClick(this));

		Button resetBtn = new Button(group, SWT.NONE);
		resetBtn.setText("Reset");
		resetBtn.setBounds(430, 420, 100, 50);
		resetBtn.addMouseListener(new BtnMappingResetClick(this));

		group.pack();

	}

	public ImageMappingTranseServerUI(Composite parent) {

		super(parent, SWT.NONE);

		InitUI();

		resetImageMappingTranseServerUI();
		//
		this.listViewComposit.getList().addSelectionListener(
				new ListMappingList(this));

		// TODO Auto-generated constructor stub
	}

	public void resetImageMappingTranseServerUI() {

		String[] lists = getListViewComposit().getList().getItems();
		for (String list : lists) {
			getPicPatientCanvas().deletePicture(list);
		}

		getPicPatientCanvas().setMainImage("0");
		resetMappingList();
		resetPatientLabelInfo();
		resetImageLabelInfo();
	}

	public void resetMappingList() {

		this.picPatientCanvas.deleteAllPicture();
		this.listViewComposit.deleteListAll();
//		MappingService mappingService = (MappingService) ctx
//				.getBean("mappingServiceSqlite");

		MappingService mappingService = new MappingServiceSqlite();
		
		java.util.List<MappingInfo> lists = mappingService.getMappingList();

		for (MappingInfo mappingInfo : lists) {
			this.picPatientCanvas.addPicture(mappingInfo.getIMGORGNAM() + "."
					+ mappingInfo.getIMGTYP(), mappingInfo.getIMGSAVNAM());
			this.listViewComposit.addList(mappingInfo.getIMGORGNAM() + "."
					+ mappingInfo.getIMGTYP(), mappingInfo);
		}

		this.picPatientCanvas.setMainImage("0");
	}

	public void resetPatientLabelInfo() {

		labelChtTitleContents.setText("");
		labelOcmTitleContents.setText("");
		labelNameContents.setText("");
		labelAgeContents.setText("");
		labelSexContents.setText("");
		labelDepContents.setText("");
		labelMeDeviceContents.setText("");

	}

	public void resetImageLabelInfo() {

		labelImageNameContents.setText("");
		labelImageSaveDtmContents.setText("");

	}

}

class BtnRollBackClick implements MouseListener {

	private ImageMappingTranseServerUI imageMappingTranseServerUI;

	public BtnRollBackClick(ImageMappingTranseServerUI imageMappingUI) {
		// TODO Auto-generated constructor stub
		this.imageMappingTranseServerUI = imageMappingUI;
	}

	@Override
	public void mouseDoubleClick(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDown(MouseEvent arg0) {
		// TODO Auto-generated method stub

		int selectindex = this.imageMappingTranseServerUI.getListViewComposit()
				.getList().getSelectionIndex();

//		ApplicationContext ctx = SpringContextFactory.getInstance();

		if (selectindex > -1) {
			MappingInfo mappingInfo = (MappingInfo) this.imageMappingTranseServerUI
					.getListViewComposit().getList(selectindex);

//			MappingService mappingService = (MappingService) ctx
//					.getBean("mappingServiceSqlite");
			MappingService mappingService = new MappingServiceSqlite();
			int returnInt = mappingService.doRollBack(mappingInfo);
			if (returnInt <= 0) {
				return;
			}
			this.imageMappingTranseServerUI.getPicPatientCanvas()
					.deletePicture(
							this.imageMappingTranseServerUI
									.getListViewComposit().getList()
									.getItem(selectindex));

			// this.imageMappingUI.getPictureListViewer().getList().remove(selectindex);
			this.imageMappingTranseServerUI.getListViewComposit().deleteList(
					selectindex);
			if (selectindex > 0) {
				selectindex = selectindex - 1;
				// imageList.getList().getItem(imageList.getList().getSelectionIndex())
				this.imageMappingTranseServerUI.getPicPatientCanvas()
						.setMainImage(
								this.imageMappingTranseServerUI
										.getListViewComposit().getList()
										.getItem(selectindex));
				this.imageMappingTranseServerUI.getListViewComposit().getList()
						.select(selectindex);

			} else {
				if (this.imageMappingTranseServerUI.getListViewComposit()
						.getList().getItemCount() > 0) {
					selectindex = 0;
					this.imageMappingTranseServerUI.getPicPatientCanvas()
							.setMainImage(
									this.imageMappingTranseServerUI
											.getListViewComposit().getList()
											.getItem(0));
					this.imageMappingTranseServerUI.getListViewComposit()
							.getList().select(selectindex);

				} else {
					selectindex = -1;
					this.imageMappingTranseServerUI.getPicPatientCanvas()
							.setMainImage("0");
				}

			}

			if (selectindex >= 0) {
				mappingInfo = (MappingInfo) this.imageMappingTranseServerUI
						.getListViewComposit().getList(selectindex);

			} else {

				mappingInfo = new MappingInfo();

			}

			this.imageMappingTranseServerUI.getLabelImageNameContents()
					.setText(
							mappingInfo.getIMGSAVNAM() + "."
									+ mappingInfo.getIMGTYP());
			this.imageMappingTranseServerUI.getLabelImageSaveDtmContents()
					.setText(mappingInfo.getIMGRCVDTE());

		}

	}

	@Override
	public void mouseUp(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

class BtnCommitClick implements MouseListener {

	private ImageMappingTranseServerUI imageMappingUI;

	public BtnCommitClick(ImageMappingTranseServerUI imageMappingUI) {
		// TODO Auto-generated constructor stub
		this.imageMappingUI = imageMappingUI;
	}

	@Override
	public void mouseDoubleClick(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDown(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int listViewCompositeIndex = this.imageMappingUI.getListViewComposit()
				.getList().getSelectionIndex();
		ApplicationContext ctx = SpringContextFactory.getInstance();

		if (listViewCompositeIndex > -1) {
			int returnInt = -1;
			MappingInfo mappingInfo = (MappingInfo) this.imageMappingUI
					.getListViewComposit().getList(listViewCompositeIndex);
			TranseService transeService = (TranseService) ctx
					.getBean("transeServiceJSON");

			returnInt = transeService.doUpdateServer("Y",
					mappingInfo.getMCHNUM());
			if (returnInt <= 0) {
				return;
			}

			this.imageMappingUI.getPicPatientCanvas().deletePicture(
					this.imageMappingUI.getListViewComposit().getList()
							.getItem(listViewCompositeIndex));

			// this.imageMappingUI.getPictureListViewer().getList().remove(selectindex);
			this.imageMappingUI.getListViewComposit().deleteList(
					listViewCompositeIndex);
			if (listViewCompositeIndex > 0) {
				listViewCompositeIndex = listViewCompositeIndex - 1;
				// imageList.getList().getItem(imageList.getList().getSelectionIndex())
				this.imageMappingUI.getPicPatientCanvas().setMainImage(
						this.imageMappingUI.getListViewComposit().getList()
								.getItem(listViewCompositeIndex));
				this.imageMappingUI.getListViewComposit().getList()
						.select(listViewCompositeIndex);

			} else {
				if (this.imageMappingUI.getListViewComposit().getList()
						.getItemCount() > 0) {
					listViewCompositeIndex = 0;
					this.imageMappingUI.getPicPatientCanvas().setMainImage(
							this.imageMappingUI.getListViewComposit().getList()
									.getItem(0));
					this.imageMappingUI.getListViewComposit().getList()
							.select(listViewCompositeIndex);

				} else {
					listViewCompositeIndex = -1;
					this.imageMappingUI.getPicPatientCanvas().setMainImage("0");
				}

			}

			if (listViewCompositeIndex >= 0) {
				mappingInfo = (MappingInfo) this.imageMappingUI
						.getListViewComposit().getList(listViewCompositeIndex);

			} else {

				mappingInfo = new MappingInfo();

			}

			this.imageMappingUI.getLabelImageNameContents().setText(
					mappingInfo.getIMGSAVNAM() + "." + mappingInfo.getIMGTYP());
			this.imageMappingUI.getLabelImageSaveDtmContents().setText(
					mappingInfo.getIMGRCVDTE());
		}

	}

	@Override
	public void mouseUp(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

class ListMappingList implements SelectionListener {

	private ImageMappingTranseServerUI imageMappingTranseServerUI;

	public ListMappingList(ImageMappingTranseServerUI imageMappingTranseServerUI) {
		// TODO Auto-generated constructor stub
		this.imageMappingTranseServerUI = imageMappingTranseServerUI;

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		int selectindex = this.imageMappingTranseServerUI.getListViewComposit()
				.getList().getSelectionIndex();

		if (selectindex > -1) {
			System.out.println("selection : "
					+ this.imageMappingTranseServerUI.getListViewComposit()
							.getList().getSelectionIndex());

			MappingInfo mappingInfo = (MappingInfo) this.imageMappingTranseServerUI
					.getListViewComposit().getList(selectindex);
			System.out.println(mappingInfo);

			//
			this.imageMappingTranseServerUI.getPicPatientCanvas().setMainImage(
					this.imageMappingTranseServerUI
							.getListViewComposit()
							.getList()
							.getItem(
									this.imageMappingTranseServerUI
											.getListViewComposit().getList()
											.getSelectionIndex()));
			this.imageMappingTranseServerUI.getLabelImageNameContents()
					.setText(
							mappingInfo.getIMGSAVNAM() + "."
									+ mappingInfo.getIMGTYP());
			this.imageMappingTranseServerUI.getLabelImageSaveDtmContents()
					.setText(mappingInfo.getIMGRCVDTE());

			this.imageMappingTranseServerUI.getLabelChtTitleContents().setText(
					mappingInfo.getMCHCHTNUM());
			this.imageMappingTranseServerUI.getLabelOcmTitleContents().setText(
					mappingInfo.getMCHOCMNUM());
			this.imageMappingTranseServerUI.getLabelNameContents().setText(
					mappingInfo.getPBSNAM());
			this.imageMappingTranseServerUI.getLabelAgeContents().setText(
					String.valueOf(mappingInfo.getPBSAGE()));
			this.imageMappingTranseServerUI.getLabelSexContents().setText(
					String.valueOf(mappingInfo.getPBSSEX()));
			this.imageMappingTranseServerUI.getLabelDepContents().setText(
					mappingInfo.getPBSDEP());
		}

	}

}

class BtnMappingResetClick implements MouseListener {

	private ImageMappingTranseServerUI imageMappingTranseServerUI;

	public BtnMappingResetClick(
			ImageMappingTranseServerUI imageMappingTranseServerUI) {
		// TODO Auto-generated constructor stub
		this.imageMappingTranseServerUI = imageMappingTranseServerUI;
	}

	@Override
	public void mouseDoubleClick(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDown(MouseEvent arg0) {
		// TODO Auto-generated method stub

		this.imageMappingTranseServerUI.resetImageMappingTranseServerUI();

	}

	@Override
	public void mouseUp(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
