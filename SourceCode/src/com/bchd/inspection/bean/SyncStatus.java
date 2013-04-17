package com.bchd.inspection.bean;

public enum SyncStatus 
{
		/** 
		 未同步
		*/
		NotSync(0),
		/** 
		 已经同步
		*/
		Synced(1),
		/** 
		 已同步，但仍还要在本条基础上Update,比如CheckSheet,第一次同步时，还没有填写下班时间，
		 但由于它是其它信息的主记录，所以同步其它数据前，最好先同步它。此时先将其状态设置为2。等到填写下岗时间时，将其设置为3。如果同步完了，则就可以设置为1了
		*/
		PendingSyncUpdate(2),
		/** 
		 数据已经同步到服务器上了，现在需要将其最数据更新到服务上
		 比如，CheckSheet的下岗时间填完了，是时候把它更新到服务器上了
		*/
		ReadyForSyncedUpdate(3);

		private int intValue;
		private static java.util.HashMap<Integer, SyncStatus> mappings;
		private static java.util.HashMap<Integer, SyncStatus> getMappings()
		{
			if (mappings == null)
			{
				synchronized (SyncStatus.class)
				{
					if (mappings == null)
					{
						mappings = new java.util.HashMap<Integer, SyncStatus>();
					}
				}
			}
			return mappings;
		}

		private SyncStatus(int value)
		{
			intValue = value;
			getMappings().put(value, this);
		}

		public int getValue()
		{
			return intValue;
		}

		public static SyncStatus forValue(int value)
		{
			return getMappings().get(value);
		}
}
