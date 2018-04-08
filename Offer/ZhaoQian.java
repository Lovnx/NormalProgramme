package offer;

public class ZhaoQian
{
	public static void main(String[] args)
	{
		// ����ض�ʵ����Ҫ��100Ԫ�һ�Ϊ1Ԫ��5Ԫ��10Ԫ����Ǯ�������ж����ֶһ�������
		int money = 100;
		System.out.println(baseFun(money));
		System.out.println(getDivideWays());
		int[] coinKinds = { 1, 5, 10 };
		System.out.println(cc(money, coinKinds.length));
	}

	// �ݹ�ʵ��
	/**
	 * @param mount
	 *            ��Ǯ����
	 * @param coinKinds
	 *            ��Ǯ��������
	 */
	// ������Ϊa���ֽ𻻳�n�ֲ�ͬ��ֵ�Ĳ�ͬ��ʽ����Ŀ���ڣ�
	// ���ֽ�a���ɳ��˵�һ����ֵ֮�������������ֵ�Ĳ�ͬ��ʽ��Ŀ������
	// ���ֽ�a-d���������������ֵ�Ĳ�ͬ��ʽ��Ŀ������d�ǵ�һ����ֵ��Ǯ��
	private static int cc(int mount, int coinKinds)
	{
		// ���a==0,Ӧ����������1�ֻ���Ǯ�ķ�ʽ : ������ֵ��Ǯ�պñ�������
		if (mount == 0)
			return 1;
		// ���n=0��Ӧ����������0�ֻ���Ǯ�ķ�ʽ
		// ���a<0,Ӧ����������0�л���Ǯ�ķ�ʽ
		if (mount <= 0 || coinKinds == 0)
			return 0;
		return cc(mount, coinKinds - 1) + cc(mount - denomination(coinKinds), coinKinds);
	}

	private static int denomination(int coinKinds)
	{
		switch (coinKinds)
		{
		case 1:
			return 1;
		case 2:
			return 5;
		default:
			return 10;
		}
	}

	/**
	 * 1������ض�ʵ����Ҫ��100Ԫ�һ�Ϊ1Ԫ��5Ԫ��10Ԫ����Ǯ�������ж����ֶһ������� ���10��ÿ������������5����������������0��5 �� n��
	 * n=(100 - i * 10)/5 ��5��n+1�����
	 */

	private static int getDivideWays()
	{
		int count = 0;
		for (int i = 0; i <= 100 / 10; i++)
		{
			count += (100 - 10 * i) / 5 + 1;
		}
		return count;
	}

	private static int baseFun(int money)
	{
		int count = 0;
		for (int i = 0; i <= 10; i++)
		{
			for (int j = 0; j <= 20; j++)
			{
				for (int k = 0; k <= 100; k++)
				{
					if (10 * i + 5 * j + k == 100)
					{
						count++;
					}
				}
			}
		}
		return count;
	}
}
