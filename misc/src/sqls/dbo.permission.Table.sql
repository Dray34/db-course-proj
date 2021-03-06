﻿USE [豆瓣数据库]
GO
/****** Object:  Table [dbo].[permission]    Script Date: 11/15/2019 09:50:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[permission](
	[permission_id] [int] NOT NULL,
	[url] [char](30) NOT NULL,
	[description] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[permission_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[permission] ADD  DEFAULT ('') FOR [url]
GO
ALTER TABLE [dbo].[permission] ADD  DEFAULT ('') FOR [description]
GO
