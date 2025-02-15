package engine.data;
import engine.simulation.Frontiere;
import engine.simulation.Pays;
import java.awt.Color;
import java.util.ArrayList;

public class ListePays {
	private ArrayList<Pays> listepays;
	public ListePays() {
		this.listepays = new ArrayList<>();
		int[] franceX = {927, 912, 912, 888, 888, 863, 851, 857, 835, 829, 817, 801, 803, 836, 853, 856, 846, 836, 860, 894, 914, 928, 927, 947, 986, 1009, 1013, 1003, 994, 1004, 1001, 983, 1007, 1011, 1021, 1003, 978, 956, 934, 927};
		int[] franceY = {351, 355, 372, 382, 392, 382, 382, 406, 407, 398, 400, 403, 423, 437, 466, 487, 524, 540, 555, 563, 572, 571, 557, 544, 557, 539, 530, 527, 503, 494, 472, 474, 447, 427, 406, 401, 392, 372, 361, 351};
		int[] espagneX = {929, 916, 860, 836, 803, 774, 747, 732, 711, 715, 729, 753, 753, 751, 749, 740, 744, 735, 737, 745, 765, 793, 840, 862, 866, 881, 871, 887, 915, 934, 929};
		int[] espagneY = {571, 572, 555, 540, 543, 539, 536, 532, 550, 581, 590, 596, 601, 618, 646, 693, 714, 727, 739, 740, 760, 759, 757, 731, 710, 691, 667, 630, 607, 584, 571};
		int[] portugalX = {756, 762, 753, 729, 715, 697, 700, 689, 678, 670, 689, 686, 701, 695, 717, 745, 735, 744, 740};
		int[] portugalY = {628, 609, 596, 589, 581, 592, 620, 669, 697, 722, 709, 722, 722, 759, 763, 740, 727, 714, 693};
		int[] empireX = {1114, 1082, 1081, 1065, 1065, 1043, 1045, 1030, 1009, 927, 955, 974, 1004, 1009, 984, 1002, 1004, 994, 1004, 1014, 1009, 1052, 1074, 1124, 1157, 1196, 1218, 1244, 1246, 1249, 1268, 1287, 1291, 1290, 1275, 1241, 1235, 1250};
		int[] empireY = {290, 290, 307, 323, 308, 311, 336, 317, 337, 351, 374, 393, 401, 427, 475, 472, 495, 502, 527, 530, 539, 533, 564, 556, 522, 524, 538, 494, 450, 426, 401, 401, 371, 344, 318, 312, 302, 272};
		int[] angleterreX = {769, 731, 726, 711, 711, 697, 709, 705, 719, 721, 738, 730, 769, 757, 757, 772, 759, 741, 753, 748, 727, 747, 783, 772, 748, 720, 758, 765, 852, 861, 844, 870, 855, 835, 834, 806, 792, 761, 779, 795, 754, 748, 770};
		int[] angleterreY = {151, 151, 159, 174, 174, 175, 194, 221, 224, 209, 221, 237, 233, 245, 245, 253, 274, 273, 284, 298, 307, 314, 311, 323, 325, 348, 346, 337, 328, 321, 317, 296, 283, 283, 262, 241, 216, 211, 202, 173, 190, 175, 151};
		int[] italieX = {1037, 1028, 1016, 1005, 1012, 1000, 1007, 1003, 1016, 1017, 1044, 1063, 1090, 1129, 1145, 1156, 1170, 1172, 1191, 1198, 1188, 1176, 1147, 1134, 1130, 1120, 1119, 1177, 1179, 1178, 1192, 1199, 1219, 1222, 1206, 1208, 1215, 1215, 1238, 1242, 1250, 1246, 1228, 1192, 1198, 1192, 1182, 1165, 1151, 1143, 1125, 1113, 1113, 1143, 1143, 1119, 1114, 1100, 1089, 1080, 1072, 1056, 1052, 1038};
		int[] italieY = {544, 554, 553, 558, 569, 574, 583, 591, 596, 605, 592, 601, 640, 667, 671, 684, 684, 695, 701, 723, 737, 741, 748, 741, 745, 745, 754, 778, 766, 757, 746, 746, 724, 713, 707, 700, 684, 684, 689, 699, 698, 688, 677, 664, 656, 652, 653, 649, 640, 614, 605, 592, 572, 563, 543, 538, 531, 533, 538, 535, 547, 545, 556, 544};
		Pays France = new Pays("France", 68000000, 1, franceX, franceY, Color.BLUE, null);
		Pays Espagne = new Pays("Espagne", 47000000, 1, espagneX, espagneY, Color.RED, null);
		Pays SaintEmpire = new Pays("Saint Empire", 10000, 1, empireX, empireY, Color.BLACK, null);
		Pays Portugal = new Pays("Portugal", 1000000, 1, portugalX, portugalY, Color.ORANGE, null);
		Pays Angleterre = new Pays("Angleterre", 53000000, 1, angleterreX, angleterreY, Color.GRAY, null);
		Pays Italie = new Pays("Italie", 60000000, 1, italieX, italieY, Color.GREEN, null);
		this.listepays.add(Espagne);
		this.listepays.add(SaintEmpire);
		this.listepays.add(France);
		this.listepays.add(Portugal);
		this.listepays.add(Angleterre);
		this.listepays.add(Italie);
	}
	public ArrayList<Pays> getListePays(){
		return this.listepays;
	}
	public Pays getPays(String nom) {
		for(Pays pays: listepays) {
			if (pays.getNom().equals(nom)) {
				return pays;
			}
		}
		return null;
	}
}