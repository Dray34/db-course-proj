USE [豆瓣数据库]
GO
/****** Object:  Table [dbo].[favor]    Script Date: 11/15/2019 09:50:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[favor](
	[favor_id] [int] NOT NULL,
	[favors] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[favor_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
