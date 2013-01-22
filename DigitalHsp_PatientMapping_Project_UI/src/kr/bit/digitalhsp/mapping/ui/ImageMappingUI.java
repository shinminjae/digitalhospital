package kr.bit.digitalhsp.mapping.ui;

import java.sql.SQLDataException;

import kr.bit.digitalhsp.mapping.configuration.SpringContextFactory;
import kr.bit.digitalhsp.mapping.exception.ErrorException;
import kr.bit.digitalhsp.mapping.service.MappingService;
import kr.bit.digitalhsp.mapping.service.TranseService;
import kr.bit.digitalhsp.mapping.service.sqlite3.MappingServiceSqlite;
import kr.bit.digitalhsp.mapping.service.sqlite3.TranseServiceJSON;
import kr.bit.digitalhsp.mapping.vo.ImageInfo;
import kr.bit.digitalhsp.mapping.vo.PatientInfo;

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


public class ImageMappingUI extends Composite {

	private ListViewComposit pictureListViewer;
	private ListViewComposit patientListViewer;
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
	
	//ApplicationContext ctx = SpringContextFactory.getInstance();

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

	

	public ListViewComposit getPictureListViewer() {
		return pictureListViewer;
	}

	public void setPictureListViewer(ListViewComposit pictureListViewer) {
		this.pictureListViewer = pictureListViewer;
	}

	public ListViewComposit getPatientListViewer() {
		return patientListViewer;
	}

	public void setPatientListViewer(ListViewComposit patientListViewer) {
		this.patientListViewer = patientListViewer;
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

		this.pictureListViewer = new ListViewComposit(group, SWT.BORDER
				| SWT.V_SCROLL);
		this.patientListViewer = new ListViewComposit(group, SWT.BORDER
				| SWT.V_SCROLL);

		this.pictureListViewer.getList().setBounds(0, 0, 224, 229);
		this.patientListViewer.getList().setBounds(0, 247, 224, 182);
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

		Button resetBtn = new Button(group, SWT.NONE);
		resetBtn.setText("Mapping");
		resetBtn.setBounds(230, 420, 100, 50);
		resetBtn.addMouseListener(new BtnMappingClick(this));

		Button mappingBtn = new Button(group, SWT.NONE);
		mappingBtn.setText("Reset");
		mappingBtn.setBounds(330, 420, 100, 50);
		mappingBtn.addMouseListener(new BtnResetClick(this));

		group.pack();

	}

	public ImageMappingUI(Composite parent) {

		super(parent, SWT.NONE);

		InitUI();

		resetPictureList();
		resetPatientList();
		//
		this.pictureListViewer.getList().addSelectionListener(
				new ListPictureSelect(this));

		// this.pictureListViewer.getList().addMouseListener(new
		// ListPictureMouseClick(this));
		this.patientListViewer.getList().addSelectionListener(
				new ListPatientSelect(this));

		// TODO Auto-generated constructor stub
	}

	public void resetImageMappingUI() {

		String[] lists = getPictureListViewer().getList().getItems();
		for (String list : lists) {
			getPicPatientCanvas().deletePicture(list);
		}

		getPicPatientCanvas().setMainImage("0");
		resetPatientList();
		resetPictureList();
	}

	public void resetPictureList() {

		this.picPatientCanvas.deleteAllPicture();
		this.pictureListViewer.deleteListAll();
		ApplicationContext ctx = SpringContextFactory.getInstance();
		MappingService mappingService = (MappingService) ctx
				.getBean("mappingServiceSqlite");
		
	//	MappingService mappingService = new MappingServiceSqlite();
		
		java.util.List<ImageInfo> lists = mappingService.getMappingImageList("20121227", "20121227");

		for (ImageInfo imageInfo : lists) {
			this.picPatientCanvas.addPicture(imageInfo.getIMGORGNAM() + "."
					+ imageInfo.getIMGTYP(), imageInfo.getIMGSAVNAM());
			this.pictureListViewer.addList(imageInfo.getIMGORGNAM() + "."
					+ imageInfo.getIMGTYP(), imageInfo);
		}

		this.picPatientCanvas.setMainImage("0");
	}

	public void resetPatientList() {

		this.patientListViewer.deleteListAll();
//		TranseService transeService = (TranseService) ctx
//				.getBean("transeServiceJSON");
//		
		TranseService transeService = new TranseServiceJSON();
		
		java.util.List<PatientInfo> lists = transeService
				.getPatientList("20121227");
		for (PatientInfo patientInfo : lists) {
			patientListViewer.addList(
					patientInfo.getName() + "(" + patientInfo.getChtNumber()
							+ ")", patientInfo);
		}
		resetPatientLabelInfo();
		resetImageLabelInfo();
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

class BtnResetClick implements MouseListener {

	private ImageMappingUI imageMappingUI;

	public BtnResetClick(ImageMappingUI imageMappingUI) {
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

		this.imageMappingUI.resetImageMappingUI();

	}

	@Override
	public void mouseUp(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

class BtnMappingClick implements MouseListener {

	private ImageMappingUI imageMappingUI;

	public BtnMappingClick(ImageMappingUI imageMappingUI) {
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
		int selectindex = this.imageMappingUI.getPictureListViewer().getList()
				.getSelectionIndex();
		int patSelectindex = this.imageMappingUI.getPatientListViewer()
				.getList().getSelectionIndex();
		//ApplicationContext ctx = SpringContextFactory.getInstance();

		if (selectindex > -1 && patSelectindex > -1) {
			PatientInfo patientInfo = (PatientInfo) this.imageMappingUI
					.getPatientListViewer().getList(patSelectindex);
			ImageInfo imageInfo = (ImageInfo) this.imageMappingUI
					.getPictureListViewer().getList(selectindex);

//			MappingService mappingService = (MappingService) ctx
//					.getBean("mappingServiceSqlite");
			
			MappingService mappingService = new MappingServiceSqlite();
			
			
			int returnInt = -1;
			try {
				returnInt = mappingService.doMapping(imageInfo, patientInfo);
			} catch (SQLDataException e) {
				// TODO Auto-generated catch block
				System.out.println("에러발생");
			} catch (ErrorException e) {
				// TODO Auto-generated catch block
				
			}
			
			if (returnInt <= 0) {
				return;
			}
			this.imageMappingUI.getPicPatientCanvas().deletePicture(
					this.imageMappingUI.getPictureListViewer().getList()
							.getItem(selectindex));

			// this.imageMappingUI.getPictureListViewer().getList().remove(selectindex);
			this.imageMappingUI.getPictureListViewer().deleteList(selectindex);
			if (selectindex > 0) {
				selectindex = selectindex - 1;
				// imageList.getList().getItem(imageList.getList().getSelectionIndex())
				this.imageMappingUI.getPicPatientCanvas().setMainImage(
						this.imageMappingUI.getPictureListViewer().getList()
								.getItem(selectindex));
				this.imageMappingUI.getPictureListViewer().getList()
						.select(selectindex);

			} else {
				if (this.imageMappingUI.getPictureListViewer().getList()
						.getItemCount() > 0) {
					selectindex = 0;
					this.imageMappingUI.getPicPatientCanvas().setMainImage(
							this.imageMappingUI.getPictureListViewer()
									.getList().getItem(0));
					this.imageMappingUI.getPictureListViewer().getList()
							.select(selectindex);

				} else {
					selectindex = -1;
					this.imageMappingUI.getPicPatientCanvas().setMainImage("0");
				}

			}

			if (selectindex >= 0) {
				imageInfo = (ImageInfo) this.imageMappingUI
						.getPictureListViewer().getList(selectindex);

			} else {

				imageInfo = new ImageInfo();

			}

			this.imageMappingUI.getLabelImageNameContents().setText(
					imageInfo.getIMGSAVNAM() + "." + imageInfo.getIMGTYP());
			this.imageMappingUI.getLabelImageSaveDtmContents().setText(
					imageInfo.getIMGRCVDTE());

		}

	}

	@Override
	public void mouseUp(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

class ListPictureSelect implements SelectionListener {

	private ImageMappingUI imageMappingUI;

	public ListPictureSelect(ImageMappingUI imageMappingUI) {
		// TODO Auto-generated constructor stub
		this.imageMappingUI = imageMappingUI;

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		int selectindex = this.imageMappingUI.getPictureListViewer().getList()
				.getSelectionIndex();

		if (selectindex > -1) {
			System.out.println("selection : "
					+ this.imageMappingUI.getPictureListViewer().getList()
							.getSelectionIndex());

			ImageInfo imageInfo = (ImageInfo) this.imageMappingUI
					.getPictureListViewer().getList(selectindex);
			System.out.println(imageInfo);

			this.imageMappingUI.getPicPatientCanvas().setMainImage(
					this.imageMappingUI
							.getPictureListViewer()
							.getList()
							.getItem(
									this.imageMappingUI.getPictureListViewer()
											.getList().getSelectionIndex()));
			this.imageMappingUI.getLabelImageNameContents().setText(
					imageInfo.getIMGSAVNAM() + "." + imageInfo.getIMGTYP());
			this.imageMappingUI.getLabelImageSaveDtmContents().setText(
					imageInfo.getIMGRCVDTE());
		}

	}

}

// SelectionListener

class ListPatientSelect implements SelectionListener {

	private ImageMappingUI imageMappingUI;

	public ListPatientSelect(ImageMappingUI imageMappingUI) {
		// TODO Auto-generated constructor stub
		this.imageMappingUI = imageMappingUI;
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		int selectindex = this.imageMappingUI.getPatientListViewer().getList()
				.getSelectionIndex();

		if (selectindex > -1) {
			System.out.println("selection : " + selectindex);
			PatientInfo patientInfo = (PatientInfo) this.imageMappingUI
					.getPatientListViewer().getList(selectindex);
			System.out.println(this.imageMappingUI.getPatientListViewer()
					.getList(selectindex));
			this.imageMappingUI.getLabelChtTitleContents().setText(
					patientInfo.getChtNumber());
			this.imageMappingUI.getLabelOcmTitleContents().setText(
					patientInfo.getOcmNumber());
			this.imageMappingUI.getLabelNameContents().setText(
					patientInfo.getName());
			this.imageMappingUI.getLabelAgeContents().setText(
					String.valueOf(patientInfo.getAge()));
			this.imageMappingUI.getLabelSexContents().setText(
					String.valueOf(patientInfo.getSex()));
			this.imageMappingUI.getLabelDepContents().setText(
					patientInfo.getDepName());

		}

	}

}
