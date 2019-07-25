package opencv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfInt4;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Range;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.video.BackgroundSubtractorMOG2;
import org.opencv.video.Video;
import org.opencv.videoio.VideoCapture;
import org.opencv.core.CvType;

public class Hand_detect {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	static ArrayList<Double> HullList = new ArrayList<Double>();

	public static void main(String arg[]) throws Exception {
		JFrame frame1 = new JFrame("Camera");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(640, 480);
		frame1.setBounds(0, 0, frame1.getWidth(), frame1.getHeight());
		Panel panel1 = new Panel();
		frame1.setContentPane(panel1);
		frame1.setVisible(true);

		JFrame frame3 = new JFrame("finger");
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setSize(640, 480);
		frame3.setBounds(300, 100, frame1.getWidth() + 50, 50 + frame1.getHeight());
		Panel panel5 = new Panel();
		frame3.setContentPane(panel5);
		frame3.setVisible(true);
		// -- 2. Read the video stream
		VideoCapture capture = new VideoCapture();
		capture.open(1);
		Mat webcam_image = new Mat();
		capture.read(webcam_image);
		frame1.setSize(webcam_image.width() + 40, webcam_image.height() + 60);
//		BackgroundSubtractorMOG2 backgroundSubtractorMOG = Video.createBackgroundSubtractorMOG2();
		if (capture.isOpened()) {
			while (true) {

					
				Thread.sleep(50);
				capture.read(webcam_image);
				if (!webcam_image.empty()) {
//                    Mat fgMask=new Mat();
//                    backgroundSubtractorMOG.apply(webcam_image, fgMask,0.1);
//
                   final Size kernelSize = new Size(3, 3);
                    Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, kernelSize);
                    final Point anchor = new Point(-1, -1);
//                    Imgproc.erode(fgMask,fgMask,kernel,anchor , 1);
//                    Mat maskedFrame=new Mat();
//					Core.bitwise_and(webcam_image, webcam_image, maskedFrame ,fgMask); 
                    
                    
                    
                    
					 Core.flip(webcam_image,webcam_image,1);
					   
					   
					   Mat roi=webcam_image.colRange(new Range(10,320)).rowRange(70, 430);
					   Imgproc.rectangle(webcam_image, new Point(10,70), new Point(320,430), new Scalar(0, 255, 0),3);
					
					   // Convert to HSV
					   Mat hsvFrame = new Mat(roi.rows(), roi.cols(), CvType.CV_8U, new Scalar(3));
					   Imgproc.cvtColor(roi, hsvFrame, Imgproc.COLOR_BGR2HSV,2);
//				        // define the upper and lower boundaries of the HSV pixel
//				        // intensities to be considered 'skin'
				        Scalar lower_skin = new Scalar(0,20,70);
				        Scalar upper_skin= new Scalar(20,255,255);
				        
				        Core.inRange(hsvFrame, lower_skin, upper_skin, hsvFrame);
				        



				        Mat mask = new Mat(hsvFrame.rows(), hsvFrame.cols(), CvType.CV_8U, new Scalar(3));
				        Imgproc.dilate(hsvFrame,mask, kernel, anchor,4);
				        
				        
				        final Size ksize = new Size(5, 5);
				        Imgproc.GaussianBlur(mask, mask, ksize, 100);
				        
//				        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
//				        Mat hierarchy = new Mat(mask.rows(),mask.cols(),CvType.CV_8UC1,new Scalar(0));
//						Imgproc.findContours(mask, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
//						//Imgproc.drawContours(mask, contours, -1, new Scalar(255, 0, 0),-1);
//					       double maxArea = 0;
//					       MatOfPoint max_contour = new MatOfPoint();
//
//					       Iterator<MatOfPoint> iterator = contours.iterator();
//					       while (iterator.hasNext()){
//					           MatOfPoint contour = iterator.next();
//					           double area = Imgproc.contourArea(contour);
//					           if(area > maxArea){
//					               maxArea = area;
//					               max_contour = contour;
//					           }
//					       }
//				        double epsilon = 0.0005*Imgproc.arcLength(new MatOfPoint2f(max_contour.toArray()),true);
//				        
//				        MatOfPoint2f approx = new MatOfPoint2f();
//				        Imgproc.approxPolyDP(new MatOfPoint2f(max_contour.toArray()),approx,epsilon,true);
//				        
//				        
//			           	MatOfInt hull = new MatOfInt();
//			            Imgproc.convexHull(max_contour, hull,false);
//						
//			            MatOfPoint mopHull = new MatOfPoint();
//					mopHull.create((int) hull.size().height, 1, CvType.CV_32SC2);
//					for (int j = 0; j < hull.size().height; j++) {
//						int index = (int) hull.get(j, 0)[0];
//						double[] point = new double[] { max_contour.get(index, 0)[0], max_contour.get(index, 0)[1] };
//						mopHull.put(j, 0, point);
//					}
//
//					double areahull = Imgproc.contourArea(mopHull);
//					double areacnt = Imgproc.contourArea(max_contour);
//					double arearatio = ((areahull - areacnt) / areacnt) * 100;
//					System.out.println(arearatio);
//
//					// MatOfPoint2f convert to MatOMatOfPoint2f
//					MatOfPoint approxpoint = new MatOfPoint();
//					approx.convertTo(approxpoint, CvType.CV_32S);
//
//					Imgproc.convexHull(approxpoint, hull, false);
//					MatOfInt4 defects = new MatOfInt4();
//					Imgproc.convexityDefects(approxpoint, hull, defects);
//
//
//
//					int l = 0;
//					for (int j = 0; j < defects.size().height - 1; j++) {
//						int s = (int) defects.get(j, 0)[0];// 0是top即指尖,2是down,兩指之底
//						int e = (int) defects.get(j, 0)[1];
//						int f = (int) defects.get(j, 0)[2];
//						Point start = new Point(approxpoint.get(s, 0)[0], approxpoint.get(s, 0)[1]);// 尖
//						Point end = new Point(approxpoint.get(e, 0)[0], approxpoint.get(e, 0)[1]);// 底
//						Point far = new Point(approxpoint.get(f, 0)[0], approxpoint.get(f, 0)[1]);// 底
//
//						double a = Math.sqrt(Math.pow(start.x - far.x, 2) + Math.pow(start.y - far.y, 2));
//						double b = Math.sqrt(Math.pow(far.x - start.x, 2) + Math.pow(far.y - start.y, 2));
//						double c = Math.sqrt(Math.pow(end.x - far.x, 2) + Math.pow(end.y - far.y, 2));
//						double s1 = (a + b + c) / 2;
//						double area = Math.sqrt(s1 * (s1 - a) * (s1 - b) * (s1 - c));
//
//						double d = (2 * area) / a;
//
//						double angle = getAngle(start, end, far);
//
//						if (angle <= 90&& d > 30) {
//							l += 1;
//							Imgproc.circle(roi, far,3,new Scalar(255, 0, 0), -1);
//							Imgproc.circle(roi, start,3,new Scalar(255, 255, 0), -1);
//							Imgproc.circle(roi, end,3,new Scalar(255 ,255, 0), -1);
//						}
//						Imgproc.line(roi, start, end,new Scalar(0, 0,255), 2);
//						l += 1;
//
//						if (l == 1) {
//							if (areacnt < 2000) {
//								System.out.println("Put hand in the box");
//							} else {
//								if (arearatio < 40) {
//									System.out.println(0);
//								} else {
//									System.out.println("SHOOT");
//								}
//
//							}
//						} else {
//							System.out.println("SHOOT");
//						}
//
//					}

					// -- 5. Display the image
					panel1.setimagewithMat(webcam_image);
					panel5.setimagewithMat( mask);
					frame1.repaint();
					frame3.repaint();
				} else {
					System.out.println(" --(!) No captured frame -- Break!");
					break;
				}
			}
		}
		return;
	}

	public static int findBiggestContour(List<MatOfPoint> contours) {
		int indexOfBiggestContour = -1;
		int sizeOfBiggestContour = 0;
		for (int i = 0; i < contours.size(); i++) {
			if (contours.get(i).height() > sizeOfBiggestContour) {
				sizeOfBiggestContour = contours.get(i).height();
				indexOfBiggestContour = i;
			}
		}
		return indexOfBiggestContour;
	}

	public static double getAngle(Point a, Point b, Point c) {
		double line1 = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
		double line2 = Math.sqrt(Math.pow(c.x - b.x, 2) + Math.pow(c.y - b.y, 2));
		double dot = (a.x - b.x) * (c.x - b.x) + (a.y - b.y) * (c.y - b.y);
		double angle = Math.acos(dot / (line1 * line2));
		angle = angle * 180 / Math.PI;
		return Math.round(100 * angle) / 100;

	}

	public static double getDistance(Point a,Point b){
		   //return Math.round(Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2)*100)/100);
		   return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
	   }


}
	   
	   
	    

